package com.ela.myLLM.ui;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;

import com.ela.myLLM.entity.User;
import com.ela.myLLM.service.RecordService;
import com.ela.myLLM.ui.vo.Result;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;


@Controller
@CrossOrigin(value = "*",exposedHeaders = "*",allowedHeaders = "*")
public class LlmController {
    String api=System.getenv("DASHSCOPE_API_KEY");
    @Autowired
    private RecordService recordService;

    @RequestMapping("/llm/qianwen")
    @ResponseBody //原封不动地返回“返回值”，而不是在页面里匹配字符串
    public Result qianWen(String pmt, HttpServletRequest request) throws NoApiKeyException, ApiException, InputRequiredException{
        //从请求中获取数据 封装到jwtInterceptor里了
//        String jwt=request.getHeader("Authorization");
//        Claims claims=null;
//        try{
//            //3901是primarykey
//            claims=Jwts.parser().setSigningKey("3901").parseClaimsJws(jwt).getBody();
//        }catch(ExpiredJwtException e){
//            return new Result(9004,"凭证过期，请重新登录",null);
//        }catch(SignatureException e){
//            return new Result(9005,"凭证被篡改，请警惕",null);
//        }catch(JsonParseException e){
//            return new Result(9006,"凭证可能被篡改，请警惕",null);
//        }

        //这里的request来源于jwtInterceptor加工后的结果
        User curUser=(User)request.getAttribute("user");
        Integer userId=curUser.getUserId();

        Generation gen = new Generation();
        QwenParam params = QwenParam.builder().model("qwen-turbo")
                .apiKey(api)
                .prompt(pmt)
                .seed(1234)
                .topP(0.8)
                .resultFormat("message")
                .enableSearch(false)
                .maxTokens(500)
                .temperature((float)0.85)
                .repetitionPenalty((float)1.0)
                .build();
    try{
        GenerationResult result = gen.call(params);
        System.out.println(result);
        String ret= result.getOutput().getChoices().get(0).getMessage().getContent();
        recordService.addRecord(result.getUsage().getTotalTokens(),userId,pmt,ret);
        return new Result(2000,"success",ret);
    }catch (Exception e){
        e.printStackTrace();
        return new Result(4004,"fail:"+e.getMessage(),null);
        }
    }

    @RequestMapping("/llm/wanx")
    @ResponseBody
    public Result wanx(String pmt,int nums,HttpServletRequest request) throws ApiException, NoApiKeyException {
//        ImageSynthesis is = new ImageSynthesis();
//        ImageSynthesisParam param =
//                ImageSynthesisParam.builder()
//                        .model("wanx-v1")
//                        .prompt(pmt)
//                        .n(nums)
//                        .seed(1)
//                        .size("1280*720")
//                        .style("<auto>")
//                        .build();
//        try{
//            ImageSynthesisResult result = is.call(param);
//            System.out.println(result);
//            List<String> ans=new ArrayList<>();
//            for(int i=0;i<nums;i++){
//                ans.add(result.getOutput().getResults().get(i).get("url"));
//            }
//            recordService.addRecord(nums*50,userId);
//            return new Result(2000,"success",ans);
//        }catch(Exception e){
//            return new Result(4004,"fail",e.getMessage());
//        }
        String jwt=request.getHeader("Authorization");
        try{
            //3901是primarykey
//            Claims claims=null;
//            claims=Jwts.parser().setSigningKey("3901").parseClaimsJws(jwt).getBody();
//            Integer userId=(Integer) claims.get("userId");
            User curUser=(User)request.getAttribute("user");
            Integer userId=curUser.getUserId();

            List<String> list = new ArrayList<>();
            list.add("https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067");
            recordService.addRecord(nums*50,userId,pmt, "https://img1.baidu.com/it/u=465289696,3068910287&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1067");
            return new Result(2000,"success",list);
        }catch(ExpiredJwtException e){
            return new Result(9004,"凭证过期，请重新登录",null);
        }catch(SignatureException e){
            return new Result(9005,"凭证被篡改，请警惕",null);
        }catch(JsonParseException e){
            return new Result(9006,"凭证格式错误，请重新登录",null);
        } catch(Exception e){
            return new Result(4004,"fail"+e.getMessage(),null);
        }
    }
}
