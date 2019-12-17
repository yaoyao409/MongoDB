package com.chenweiguang.dao;

import com.chenweiguang.entity.Student;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName StudentDao
 * @Description StudentDao
 * @Author 陈伟光
 * @Date 2019/12/17 8:44
 * @Version 1.0
 */
public interface StudentDao extends PagingAndSortingRepository<Student,Integer> {
    //根据名称查询
    public List<Student> findByNameLike(String name);
    //查询年龄大于20岁的学生
    public List<Student> findByAgeLike(int age);

}
