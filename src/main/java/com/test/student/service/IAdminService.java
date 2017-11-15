package com.test.student.service;

import com.test.student.vo.Admin;


public interface IAdminService {
    /**
     * 实现管理员登录
     * @param vo 包含要执行登陆检查的字段Email password
     * @return
     * @throws Exception
     */
    public Admin login(Admin vo) throws Exception;
}
