package com.wj.testJson;

import com.test.student.vo.Admin;
import com.test.util.ObjectToJson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangjian on 2017/11/9.
 */
public class TestAdmin {
    public static void main(String[] args) {
        List<Admin> all = new ArrayList<Admin>();

        for (int i = 0; i < 5; i++) {
            Admin vo = new Admin();
            vo.setEmail("123456@123.com");
            vo.setPassword("heheda");
            vo.setLastdate(new Date());
            all.add(vo);
        }
        System.out.println(ObjectToJson.convertorListToJson("allAdmin",all));
    }
}
