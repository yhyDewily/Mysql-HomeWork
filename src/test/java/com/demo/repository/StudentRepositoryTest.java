package com.demo.repository;

import com.demo.dataobject.Student;
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
public class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @Test
    public void findOneTest() {
        Student student = repository.getOne("S1");
        System.out.println(student.toString());
    }

    @Test
    public void findBySdeptTest() {
        List<Student> result = repository.findBySdeptIn("计算机软件");
        Assert.assertNotEquals(0, result.size());
    }
}