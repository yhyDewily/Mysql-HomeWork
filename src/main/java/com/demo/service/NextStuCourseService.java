package com.demo.service;

import com.demo.dataobject.Course;
import com.demo.dataobject.NextStuCourse;

public interface NextStuCourseService {

    //查询课程
    Course findOne(String cno);

    //添加课程
    void addOne(String sno, String cno);

    //删除课程
    void  delOne(String sno, String cno);

}
