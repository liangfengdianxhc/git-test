package com.hegong.controller;

import com.hegong.domain.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 14767
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("美美");
        user.setAge(18);
        user.setPassword("123456");
        //将user存入request域中
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行。。。");
        User user = new User();
        user.setUsername("美美");
        user.setAge(18);
        user.setPassword("123456");
        //把user对象存储到mv对象的map中，同样会将user存入request域
        mv.addObject("user",user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    //        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
    //        response.sendRedirect(request.getContextPath()+"/index.jsp");
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行。。");
        System.out.println(request.getContextPath());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("hello你好");
    }

    /**
     * 使用关键字来实现转发和重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了");
//        //固定语法，forward:
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了");
        System.out.println(user);
        user.setAge(50);
        user.setUsername("newName");
        user.setPassword("15874");
        return user;
    }
}
