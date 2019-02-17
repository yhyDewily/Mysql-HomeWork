package com.demo.controller;

import com.demo.VO.CourseVO;
import com.demo.VO.ResultVO;
import com.demo.VO.StuCourseVO;
import com.demo.dataobject.Course;
import com.demo.dataobject.NextStuCourse;
import com.demo.repository.CourseRepository;
import com.demo.repository.NextStuCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class NextCourseController {

    @Autowired
    NextStuCourseRepository nextStuCourseRepository;

    @Autowired
    CourseRepository courseRepository;

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/next/course", produces = "application/json; charset=UTF-8")
    public List<Course> getNextCourses(@RequestBody Map<String, String> sno) {
        String s = sno.get("sno");
        List<NextStuCourse> nextStuCourses = nextStuCourseRepository.findBySno(s);
        List<String> list = new ArrayList<>();
        for (int i = 0; i< nextStuCourses.size();i++) {
            list.add(nextStuCourses.get(i).getCno());
        }
        List<Course> courses = courseRepository.findByCnoIn(list);
        return courses;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/next/delete", produces = "application/json; charset=UTF-8")
    public ResultVO delCourse(@RequestBody StuCourseVO stuCourseVO) {
        String sno = stuCourseVO.getSno();
        String cno = stuCourseVO.getCno();
        return null;
    }


}
