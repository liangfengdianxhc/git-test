package com.hegong.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 14767
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 用于处理异常的业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        SysException exception = null;
        //确保向下转型的正确
        if (e instanceof SysException){
            exception = (SysException)e;
        }else {
            exception = new SysException("系统正在维护");
        }

        //创建modelandview对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",exception.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
