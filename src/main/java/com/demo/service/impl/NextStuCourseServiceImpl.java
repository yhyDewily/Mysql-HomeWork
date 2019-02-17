package com.demo.service.impl;

import com.demo.dataobject.Course;
import com.demo.dataobject.NextStuCourse;
import com.demo.repository.NextStuCourseRepository;
import com.demo.service.NextStuCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NextStuCourseServiceImpl implements NextStuCourseService{

    @Autowired
    NextStuCourseRepository repository;

    @Override
    public NextStuCourse findOne(String sno, String cno) {
        return repository.findBySnoAndCno(sno, cno);
    }

    @Override
    public void addOne(String sno, String cno) {
        NextStuCourse nextStuCourse = new NextStuCourse(sno, cno);
        repository.save(nextStuCourse);
    }

    @Override
    public void delOne(String sno, String cno) {
        NextStuCourse nextStuCourse = new NextStuCourse(sno, cno);
        repository.delete(nextStuCourse);
    }
}
