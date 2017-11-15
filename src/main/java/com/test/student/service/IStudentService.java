package com.test.student.service;

import com.test.student.vo.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjian on 2017/11/13.
 */
public interface IStudentService {
    /**
     * 实现学生数据的增加操作，
     * @param vo 表示要执行的数据vo对象
     * @return 成功返回true
     * @throws Exception
     */
    public boolean insert(Student vo) throws Exception;

    /**
     * 实现数据分页查询操作
     * @param currentPage 表示当前页
     * @param lineSize 表示每页显示数
     * @return
     * @throws Exception
     */
    public Map<String,Object> listSplit(int currentPage,int lineSize)throws Exception;

    /**
     * 实现数据更新操作方法
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean update(Student vo)throws Exception;

    /**
     * 实现数据的批量操作
     * @param ids 标识要执行操作的集合数据
     * @return
     * @throws Exception
     */
    public boolean delete(List<String> ids)throws Exception;
}
