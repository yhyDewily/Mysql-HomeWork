package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c")
@Data
@Proxy(lazy = false)
public class Course {

    //课程号
    @Id
    @Column(name = "CNO")
    private String cno;

    //课程名
    private String cname;

    //学分
    private int credit;

    //所属院系
    private String cdept;

    //教师姓名
    private String tname;

    public Course() {
    }
}
