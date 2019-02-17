package com.demo.repository;

import com.demo.dataobject.SnoCnoMultilKeyClass;
import com.demo.dataobject.StudentsCourse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentsCourseRepositoryTest {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    StudentsCourseRepository repository;

    @Test
    public void testSnoCnoRepository() {
        SnoCnoMultilKeyClass snoCnoMultilKeyClass =
                new SnoCnoMultilKeyClass("S1", "C2");
        StudentsCourse studentsCourse = entityManager.find(StudentsCourse.class,snoCnoMultilKeyClass);
        System.out.println(studentsCourse.toString());
    }

    @Test
    public void findBySnoTest() {
        List<StudentsCourse> studentsCourses = repository.findBySno("S1");
        Assert.assertNotEquals(0, studentsCourses.size());
    }

    @Test
    public void findByCnoInTest() {
        List<StudentsCourse> studentsCourses = repository.findByCnoIn("C1");
        Assert.assertNotEquals(0, studentsCourses.size());
    }

    @Test
    public void findBySnoAndCnoTest() {
        StudentsCourse studentsCourses = repository.findBySnoAndCno("S1", "C2");
        System.out.println(studentsCourses);
    }

}