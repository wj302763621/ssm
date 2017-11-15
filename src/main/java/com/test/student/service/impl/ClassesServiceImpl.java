package com.test.student.service.impl;

import com.test.student.dao.IClassesDAO;
import com.test.student.service.IClassesService;
import com.test.student.vo.Classes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangjian on 2017/11/8.
 */
@Service
public class ClassesServiceImpl implements IClassesService {
    @Resource
    private IClassesDAO classesDAO;

    @Override
    public boolean insert(Classes vo) throws Exception {
        if(this.classesDAO.findByCname(vo.getCname()) == null){
            System.out.println(vo.getCname());
            return this.classesDAO.doCreate(vo);
        }
        return false;
    }

    @Override
    public List<Classes> list() throws SQLException {
        return this.classesDAO.findAll();
    }
}
