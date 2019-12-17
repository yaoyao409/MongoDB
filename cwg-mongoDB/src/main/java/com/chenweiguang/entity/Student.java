package com.chenweiguang.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @ClassName Student
 * @Description Student
 * @Author 陈伟光
 * @Date 2019/12/17 8:41
 * @Version 1.0
 */
@Document(collection = "rk15_student")
@Data
public class Student {
    @Field("_id")
    private Integer _id;
    @Field("id")
    private Integer id;//编号
    @Field("name")
    private String name;//名字
    private String code;
    private int age;//年龄
    private String phone;//手机
    private String sex;//性别


}
