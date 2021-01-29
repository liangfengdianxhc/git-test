package com.hegong.controller;

import com.hegong.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 14767
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("testException执行了。。。");
        try {
            //模拟异常
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自定义的异常信息
            throw new SysException("查询所有用户出现错误。。。");
        }
        return "success";
    }
}
