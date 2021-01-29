package com.hegong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 14767
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * ctrl+o覆盖重写该方法
     * 用于预处理，controller方法执行前执行
     * return true 的话表示放行，执行下一个拦截器，如果没有，执行controller中的方法
     * return false 表示不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了。。。。");
        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return false;
    }
}
