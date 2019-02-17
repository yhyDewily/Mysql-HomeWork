package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "s")
@Data
@Proxy(lazy = false)
public class Student {

    //学号
    @Id
    private String sno;

    //姓名
    private String sname;

    //性别
    private String sex;

    //    年龄
    private String age;

    //    院系
    private String sdept;

    //    登录号
    private String logn;

    //    密码
    private String pswd;

    public Student() {

    }
}