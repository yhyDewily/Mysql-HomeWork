package com.demo.repository;

import com.demo.dataobject.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    public void findByCnoIn() {
        List<String> list = Arrays.asList("C1", "C2");

        List<Course> result = repository.findByCnoIn(list);

        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findOneTest() {
        Course course = repository.getOne("C1");
        System.out.println(course.toString());
    }

    @Test
    public void findByCnoNotInTest() {
        List<String> list = Arrays.asList("C2", "C4", "C6", "C8");

        List<Course> results = repository.findByCnoNotIn(list);

        for ( Course result : results) {
            System.out.println(result);
        }
    }
}