package com.demo.service;

import com.demo.dataobject.NextStuCourse;
import org.springframework.stereotype.Service;

@Service
public interface NextStuCourseService {

    //查询课程
    NextStuCourse findOne(String sno, String cno);

    //添加课程
    void addOne(String sno, String cno);

    //删除课程
    void  delOne(String sno, String cno);

}
