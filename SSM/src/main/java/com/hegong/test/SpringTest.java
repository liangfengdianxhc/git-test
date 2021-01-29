package com.hegong.test;

import com.hegong.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 14767
 *
 */
public class SpringTest {
    @Test
    public void run(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService)ac.getBean("accountService");
        as.findAll();
    }
}
