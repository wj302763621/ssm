package com.wj.test;

import com.test.student.service.IAdminService;
import com.test.student.vo.Admin;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by wangjian on 2017/11/6.
 */
public class AdminServiceTest {

    @Resource
    private static ApplicationContext ctx;
    private static IAdminService adminService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        adminService = ctx.getBean("adminServiceImpl",IAdminService.class);
    }

    @Test
    public void login() throws Exception {
        Admin admin = new Admin();
        admin.setEmail("ylcto@163.com");
        admin.setPassword("22BB09850349B763292456715CC5E25F");
        System.out.println(this.adminService.login(admin));
    }
}
