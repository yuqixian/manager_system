package com.yuqixian.ms.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域拦截器
 */
public class DomainInterceptor implements HandlerInterceptor {

    /**
     * 进入controller方法之前，处理跨域问题
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        // 处理跨域请求
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods", "*");
        response.addHeader("Access-Control-Allow-Headers", "*");
        return true;// 返回true该请求才能被继续执行下去，返回false的话，请求就直接结束
    }

    /**
     * 调用完controller之后，视图渲染之前
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 整个完成之后，通常用于资源清理
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
