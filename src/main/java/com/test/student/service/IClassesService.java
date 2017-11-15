package com.test.student.service;

import com.test.student.vo.Classes;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangjian on 2017/11/8.
 */
public interface IClassesService {

    /**
     * 实现班级数据增加操作
     * @param vo 表示要执行增加操作的vo
     * @return 成功返回true，失败是false
     * @throws Exception
     */
    public boolean insert(Classes vo)throws Exception;

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Classes> list()throws SQLException;
}
