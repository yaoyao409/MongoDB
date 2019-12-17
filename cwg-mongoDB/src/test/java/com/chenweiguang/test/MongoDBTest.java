package com.chenweiguang.test;

import com.chenweiguang.dao.StudentDao;
import com.chenweiguang.entity.Student;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName MongoDBTest
 * @Description MongoDBTest
 * @Author 陈伟光
 * @Date 2019/12/17 8:40
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoDBTest {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    StudentDao studentDao;
    //添加
    @Test
    public void saveAdd(){
        for(int i=0;i<5;i++){
            Student student = new Student();
            student.setName("大大");
            student.setCode("略略略");
            student.setAge(21);
            student.setPhone("17735734031");
            student.setSex("男");
            mongoTemplate.save(student);
        }
    }
    //修改
    @Test
    public void update(){
        Update update = new Update();
        update.set("name","张三");
        update.set("sex","女");
        update.set("phone","177");
        Query query = new Query();
        Query query1 = query.addCriteria(Criteria.where("_id").is("5df826824883a9234440c022"));
        UpdateResult rk15_student = mongoTemplate.updateFirst(query, update, "rk15_student");
        System.out.println(rk15_student);

    }
    //删除
    @Test
    public void delById(){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("5df8261d4883a92af0902a8f"));
        DeleteResult rk15_student = mongoTemplate.remove(query, "rk15_student");
        System.out.println(rk15_student.wasAcknowledged());
    }
    //根据名称查询
    @Test
    public void QueryName() {
        Query query = new Query();
        Query query1 = query.addCriteria(Criteria.where("name").regex("你好啊我们"));
        System.out.println(query1);
    }
    //测试年龄大于20岁的学生
    @Test
    public void QueryAge(){
        Query query = new Query();
        Query query1 = query.addCriteria(Criteria.where("age").is(21));
        System.out.println(query1);

    }
}
