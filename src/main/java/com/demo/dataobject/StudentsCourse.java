package com.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name ="sc")
@Data
@IdClass(SnoCnoMultilKeyClass.class)
@Proxy(lazy = false)
public class StudentsCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    //学生编号
    @Id
    private String sno;

    //课程编号
    @Id
    private String cno;

    private int grade;

}
