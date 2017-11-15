package com.test.student.service.impl;

import com.test.student.dao.IAdminDAO;
import com.test.student.service.IAdminService;
import com.test.student.vo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by wangjian on 2017/11/6.
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminDAO adminDAO;
    @Override
    public Admin login(Admin vo) throws Exception {
        Admin admin = this.adminDAO.findLogin(vo);
        if (admin != null){ // 表示登录成功
            vo.setLastdate(new Date());
            this.adminDAO.doUpdate(vo);
        }
        return admin;
    }
}

