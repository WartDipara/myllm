package com.ela.myLLM.ui;

import com.ela.myLLM.entity.User;
import com.ela.myLLM.service.UserService;
import com.ela.myLLM.ui.vo.Result;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.Date;
import java.util.UUID;

@Controller
@CrossOrigin(value = "*",exposedHeaders = "*",allowedHeaders = "*") //expose是允许别人拿我们的响应头，allow是允许别人的响应头发给我
public class UserController {
    @Value("${my.upload.user}")
    private String uploadDir;

    @Autowired
    private UserService userService;

    private static final Logger log= LoggerFactory.getLogger(UserController.class);

//    @PostMapping("/user/register")
//    @ResponseBody
//    public Result register(@RequestBody  User user) { //从前端收回来的成员数据是json格式,@RequestBody注解能把json还原成User对象
////        user.setScore(50);
////            User newUser = userService.register(user);
////            if(newUser!=null){
////                return new Result(2000,"注册成功",newUser);
////            }
////            return new Result(4004,"注册失败，请检查输入信息",null);
//        try{
//            user.setScore(50);
//            User u=userService.register(user);
//            return new Result(2000,"注册成功",u);
//        }catch(Exception e){
//            return new Result(4004,"注册失败，请检查输入信息。错误信息："+e.getMessage(),null);
//        }
//    }


    //用web数据上传，适用于不带json的包含二进制文件的上传 上面那个就是不带图片上传的reg方式
    @PostMapping("/user/register")
    @ResponseBody
    public Result reg(String nickName, String loginName, String loginPwd, MultipartFile imgFile){
        try{
            User user=new User();
            user.setNickName(nickName);
            user.setLoginName(loginName);
            user.setLoginPwd(loginPwd);
            user.setScore(50);
            if(!imgFile.isEmpty()){
                File dir=new File(uploadDir);
                if(!dir.exists()){
                    dir.mkdirs();
                }

                String imgName=loginName+imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
                imgFile.transferTo(new File(uploadDir+imgName));

                user.setImg(imgName);
            }
            User u=userService.register(user);
            return new Result(2000,"注册成功",u);
        }catch(Exception e){
            return new Result(4004,"注册失败，请检查输入信息:"+e.getMessage(),null);
        }
    }

    @PostMapping("/user/login")
    @ResponseBody
    public Result login(@RequestBody User user,HttpServletResponse response){
        User currentUser = userService.login(user);
        if(currentUser!=null){
            //需要派发身份凭证，用jwt方法
            String token=jwtCreate(currentUser);
            response.setHeader("Authorization",token);
            log.debug(token);
            log.info("登录成功",user.getLoginName()+"->"+user.getNickName());
            return new Result(2000,"登录成功",currentUser);
        }
        log.error("登陆异常");
        return new Result(4004,"登录失败，请检查输入信息",null);
    }

    //用jwt来创建身份凭证
    private String jwtCreate(User currentUser){
        JwtBuilder builder = Jwts.builder();
        builder.setId(UUID.randomUUID().toString());//UUID是全球唯一编码
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis()+1000*60*60)); //一小时后失效
        String primaryKey="3901";
        builder.signWith(SignatureAlgorithm.HS256,primaryKey);
        builder.claim("userId",currentUser.getUserId());
        builder.claim("nickName",currentUser.getNickName());
        builder.claim("loginName",currentUser.getLoginName());
        builder.claim("loginPwd",currentUser.getLoginPwd());
        builder.setSubject(currentUser.getUserId()+""); //核心唯一标识
        return builder.compact(); //生成凭证
    }

}
