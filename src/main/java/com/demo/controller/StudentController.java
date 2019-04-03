package com.demo.controller;

import com.demo.dataobject.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository repository;


    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/studentinfo", produces = "application/json; charset=UTF-8")
    public Student getStudentInfo(@RequestBody Map<String, String> map) {
        String sno = map.get("id");
        Student student = repository.getOne(sno);
        return student;
    }
}
