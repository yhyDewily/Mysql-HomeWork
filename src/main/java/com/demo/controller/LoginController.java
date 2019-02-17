package com.demo.controller;

import com.demo.VO.LoginInfoVO;
import com.demo.dataobject.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private StudentRepository repository;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Student login(@Valid@RequestBody LoginInfoVO loginInfoVO, BindingResult bindingResult) {
        String sno = loginInfoVO.getSno();
        String pswd = loginInfoVO.getPswd();
        if(bindingResult.hasErrors()
            || repository.getOne(sno) == null) return null;

        Student student = repository.getOne(sno);
        if (pswd != student.getPswd()) return null;

        return student;
    }
}
