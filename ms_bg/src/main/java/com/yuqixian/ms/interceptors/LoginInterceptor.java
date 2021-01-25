package com.yuqixian.ms.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入controller方法之前，可以做登录校验
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 做登录校验
        // String token = request.getParameter("access_token");
        // response.getWriter().print("fail");
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
