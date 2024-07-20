package com.ela.myLLM.ui;

import com.ela.myLLM.entity.Record;
import com.ela.myLLM.entity.User;
import com.ela.myLLM.service.RecordService;
import com.ela.myLLM.ui.vo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(value = "*",exposedHeaders = "*",allowedHeaders = "*")
public class RecordController {
    @Autowired
    private RecordService recordService;


    @GetMapping("/record/list")
    public Result selectByUser(HttpServletRequest request){
//        List<Record> list=recordService.selectByUser(userId);
        try {
            User curUser=(User)request.getAttribute("user");
            Integer userId=curUser.getUserId();
            return new Result (2000,"查询成功",recordService.selectByUser(userId));
        }catch(ExpiredJwtException e){
            return new Result(9004,"凭证过期，请重新登录",null);
        }catch(SignatureException e){
            return new Result(9005,"凭证被篡改，请警惕",null);
        }catch(JsonParseException e){
            return new Result(9006,"凭证格式错误，请重新登录",null);
        }
    }

    public Result queryCountByDate(Integer userId){
        Integer count=recordService.queryCountByDate(userId);
        return new Result(2000,"成功",count);
    }

}
