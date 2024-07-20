package com.ela.myLLM.ui.config;

import com.ela.myLLM.ui.interceptor.JwtInterceptor;
import com.ela.myLLM.ui.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${my.upload.user}")
    private String uploadDir;
    @Override//重写这个方法的目的是为了操控拦截器 进行自定义拦截
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器 拦截所有/llm 和 /record 开头的网址访问
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/llm/**").addPathPatterns("/record/**")
                .excludePathPatterns("/user/**").excludePathPatterns("/images/**").excludePathPatterns("/images/user/**")
                .order(2);//add是添加拦截，exclude是排除拦截

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/login").excludePathPatterns("/user/register").excludePathPatterns("/images/**").excludePathPatterns("/images/user/**")
                .order(1);//order是表示执行顺序，越小优先级越高
    }

    //静态资源路径 头像
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/user/**")
                .addResourceLocations("file:"+ uploadDir+"/");
                                        //file:不能省略，这是映射关键字
    }
}
