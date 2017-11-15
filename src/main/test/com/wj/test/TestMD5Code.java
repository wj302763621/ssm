package com.wj.test;

import com.test.util.MD5Code;

/**
 * Created by wangjian on 2017/11/6.
 */
public class TestMD5Code {
    public static void main(String[] args) {
        String password = "ylcto";
        String email = "ylcto@163.com";
        System.out.println(new MD5Code().getMD5ofStr(password + email));
    }
}
