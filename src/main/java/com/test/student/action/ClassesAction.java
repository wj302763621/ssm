package com.test.student.action;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.test.student.service.IClassesService;
import com.test.student.vo.Classes;
import com.test.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by wangjian on 2017/11/8.
 */
@Controller
@RequestMapping(value = "/pages/back/classes/*")
public class ClassesAction extends DefaultAction{
    @Resource
    private IClassesService classesService;

    @RequestMapping("/classes_list")
    public void list(HttpServletResponse response){
        try {
            super.printObjectToList(response,"allClasses",this.classesService.list());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("classes_insert")
    public ModelAndView insert(Classes vo){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));
        try {
            if(this.classesService.insert(vo)){
                super.setMsgAndPath(mav,"classes.insert.success","classes.login.success");
            }else{
                super.setMsgAndPath(mav,"classes.insert.failure","classes.login.failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @Override
    public String getText() {
        return null;
    }

}
