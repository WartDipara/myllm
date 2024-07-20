package com.ela.myLLM.ui.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getAttribute("user")!=null || request.getMethod().equals("OPTIONS")){
            return true;
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print("{\"code\":9004,\"msg\":\"凭证过期，请重新登录\",\"data\":null}");
        return false;
    }
}
