package com.chenweiguang.service;

import com.chenweiguang.dao.StudentDao;
import com.chenweiguang.entity.Student;
import com.mongodb.client.result.DeleteResult;
import org.apache.el.parser.AstGreaterThanEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentService
 * @Description StudentService
 * @Author 陈伟光
 * @Date 2019/12/17 10:22
 * @Version 1.0
 */
@Service
public class StudentService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    StudentDao studentDao;
    //添加
    public String saveAdd(Map<String,Object> map,String collectionName){
        mongoTemplate.save(map,collectionName);
        return "添加成功";
    }
    //修改
    public String update(Query query, Update update,String collectionName){
        mongoTemplate.updateFirst(query,update,collectionName);
        return "修改成功";
    }
    //删除
    public DeleteResult delete(Query query,String collectionName){
        DeleteResult remove = mongoTemplate.remove(query, collectionName);
        return remove;
    }
    //根据名称查询
    public List<Student> selectByName(String name){
        List<Student> byNameLike = studentDao.findByNameLike(name);
        return byNameLike;
    }
    //查询年龄大于20岁的人儿
    public List<Student> selectAge(int age){
        List<Student> byAgeLike = studentDao.findByAgeLike(age);
        return  byAgeLike;
    }
}
