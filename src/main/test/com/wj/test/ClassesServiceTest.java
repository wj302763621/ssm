package com.wj.test;

import com.test.student.service.IClassesService;
import com.test.student.vo.Classes;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by wangjian on 2017/11/6.
 */
public class ClassesServiceTest {

    @Resource
    private static ApplicationContext ctx;
    private static IClassesService classesService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = ctx.getBean("classesServiceImpl",IClassesService.class);
    }

    @Test
    public void insert() throws Exception {
        Classes vo = new Classes();
        vo.setCname("YL004");
        vo.setNote("这是一个测试的课程");
        TestCase.assertTrue(this.classesService.insert(vo));
        System.out.println(vo.toString());
    }

    @Test
    public void list() throws Exception {

        System.out.println(this.classesService.list());
    }
}
