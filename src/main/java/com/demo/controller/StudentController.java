package com.demo.controller;

import com.demo.dataobject.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @RequestMapping("/student")
    @ResponseBody
    public Student getStudentInfo() {
        Student student = repository.getOne("S1");
        return student;
    }
}
