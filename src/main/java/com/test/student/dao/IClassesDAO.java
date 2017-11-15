package com.test.student.dao;

import com.test.student.vo.Classes;

import java.sql.SQLException;

/**
 * Created by wangjian on 2017/11/8.
 */
public interface IClassesDAO extends IDAO<Integer,Classes> {
    /**
     * 实现班级名称查询操作
     * @param cname 表示要执行查询班级的名称
     * @return
     * @throws SQLException
     */
    public Classes findByCname(String cname)throws SQLException;
}
