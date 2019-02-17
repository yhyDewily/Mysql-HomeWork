package com.demo.repository;

import com.demo.dataobject.NextStuCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NextStuCourseRepositoryTest {

    @Autowired
    NextStuCourseRepository repository;

    @Test
    public void addOneTest(){
        NextStuCourse nextStuCourse = new NextStuCourse("S1", "C1");
        repository.save(nextStuCourse);
    }

    @Test
    public void findBySnoTest() {
        List<NextStuCourse> nextStuCourses = repository.findBySno("S1");
        System.out.println(nextStuCourses);
    }

    @Test
    @Transactional
    public void deleteTest() {
        repository.removeBySnoAndCno("S1", "C1");
    }

}