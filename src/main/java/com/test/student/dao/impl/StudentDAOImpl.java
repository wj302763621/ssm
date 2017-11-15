package com.test.student.dao.impl;

import com.test.student.dao.IStudentDAO;
import com.test.student.vo.Student;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangjian on 2017/11/13.
 */
@Repository
public class StudentDAOImpl extends SqlSessionDaoSupport implements IStudentDAO {

    public StudentDAOImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    @Override
    public boolean doCreate(Student vo) throws SQLException {
        return super.getSqlSession().insert("StudentNS.doCreate",vo) > 0;
    }

    @Override
    public boolean doUpdate(Student vo) throws SQLException {
        return super.getSqlSession().update("StudentNS.doUpdate",vo) > 0;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Student findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Student> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public List<Student> findAllBySplit(Integer currentPage, Integer lineSize) throws SQLException {
        Map<String,Object> map = new HashMap<>();
        map.put("start",(currentPage-1)*lineSize);
        map.put("lineSize",lineSize);
        return super.getSqlSession().selectList("StudentNS.findBySplit",map);
    }

    @Override
    public Integer getAllCount() throws SQLException {
        return super.getSqlSession().selectOne("StudentNS.getAllCount");
    }

    @Override
    public boolean doRemoverBatch(List<String> ids) throws SQLException {
        System.out.println(ids);
        return super.getSqlSession().delete("StudentNS.doRemove",ids) > 0;
    }
}
