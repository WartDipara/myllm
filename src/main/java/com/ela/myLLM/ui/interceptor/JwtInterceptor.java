package com.ela.myLLM.ui.interceptor;

import com.ela.myLLM.entity.User;
import com.ela.myLLM.ui.vo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//必须继承interceptor类重写
public class JwtInterceptor implements HandlerInterceptor {
//    @Override //在请求处理之前进行调用（Controller方法调用之前）
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//
//    @Override //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }

    @Override //在请求处理之前进行调用（Controller方法调用之前） *用的最多是这个
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt=request.getHeader("Authorization");
        if(jwt==null){
            return true;
        }
        Claims claims=null;
        //需要改写方法，不能照常来写Json数据
//        try{
//            //3901是primarykey
//            claims= Jwts.parser().setSigningKey("3901").parseClaimsJws(jwt).getBody();
//        }catch(ExpiredJwtException e){
//            return new Result(9004,"凭证过期，请重新登录",null);
//        }catch(SignatureException e){
//            return new Result(9005,"凭证被篡改，请警惕",null);
//        }catch(JsonParseException e){
//            return new Result(9006,"凭证可能被篡改，请警惕",null);
//        }
        try{
            claims= Jwts.parser().setSigningKey("3901").parseClaimsJws(jwt).getBody();
            response.setContentType("application/json;charset=utf-8");
        }catch(ExpiredJwtException e){
            response.getWriter().print("{\"code\":9004,\"msg\":\"凭证过期，请重新登录\",\"data\":null}");
            return false;
        }catch (SignatureException e){
            response.getWriter().print("{\"code\":9005,\"msg\":\"凭证被篡改，请警惕\",\"data\":null}");
            return false;
        }
        Integer userId=(Integer)claims.get("userId");
        String nickName=(String)claims.get("nickName");
        String loginName=(String)claims.get("loginName");
        Integer score=(Integer)claims.get("score");
        User user=new User();
        user.setNickName(nickName);
        user.setLoginName(loginName);
        user.setUserId(userId);
        user.setScore(score);
        request.setAttribute("user",user);//将user对象放入request作用域中，下游的Controller可以访问到
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
