package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "nsc")
@IdClass(SnoCnoMultilKeyClass.class)
@Proxy(lazy = false)
public class NextStuCourse {

    private static final long serialVersionUID = 1L;

    //学生编号
    @Id
    private String sno;

    //课程编号
    @Id
    private String cno;

    private int grade;

    public NextStuCourse(String sno, String cno) {
        this.sno = sno;
        this.cno = cno;
        this.grade = 0;
    }

    public NextStuCourse() {
    }
}

