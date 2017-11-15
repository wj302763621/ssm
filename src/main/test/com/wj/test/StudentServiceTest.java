package com.wj.test;

import com.test.student.service.IClassesService;
import com.test.student.service.IStudentService;
import com.test.student.vo.Classes;
import com.test.student.vo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjian on 2017/11/6.
 */
public class StudentServiceTest {

    @Resource
    private static ApplicationContext ctx;
    private static IStudentService studentService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = ctx.getBean("studentServiceImpl",IStudentService.class);
    }

    @Test
    public void insert() throws Exception {
        Student vo = new Student();
        vo.setSid("YLCTo832");
        vo.setName("wang");
        vo.setAge(23);
        vo.setSex(1);
        vo.setAddress("shanghai浦东");
        Classes classes = new Classes();
        classes.setCid(1);
        vo.setClasses(classes);
        TestCase.assertTrue(this.studentService.insert(vo));


        System.out.println(vo.toString());
    }

    @Test
    public void list() throws Exception {
        Map<String,Object>map = this.studentService.listSplit(1,2);
        System.out.println(map.get("allStudent"));
        System.out.println(map.get("studentCount"));
        TestCase.assertTrue(map.size()==2);
    }

    @Test
    public void update() throws Exception {
        Student vo = new Student();
        vo.setName("wangwu");
        vo.setAge(99);
        vo.setSex(1);
        vo.setAddress("湖北here");
        vo.setSid("YLCTO2312");
        Classes classes = new Classes();
        classes.setCid(18);
        vo.setClasses(classes);

        TestCase.assertTrue(this.studentService.update(vo));
    }

    @Test
    public void delete() throws Exception {
        List<String> all = new ArrayList<>();
        all.add("YLTO0008");
        TestCase.assertTrue(this.studentService.delete(all));
    }
}
