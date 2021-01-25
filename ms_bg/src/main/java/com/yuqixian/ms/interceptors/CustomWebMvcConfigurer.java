package com.yuqixian.ms.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot新版本拦截器注册器
 *
 * @author 郁启贤
 *
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer  {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 添加跨域拦截器
        registry.addInterceptor(new DomainInterceptor()).addPathPatterns("/**");

        // 添加登录拦截器，拦截全部 /*/*/**
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/*");

    }

}