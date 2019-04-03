package com.demo.controller;

import com.demo.VO.CourseVO;
import com.demo.VO.ResultVO;
import com.demo.VO.StuCourseVO;
import com.demo.dataobject.Course;
import com.demo.dataobject.NextStuCourse;
import com.demo.repository.CourseRepository;
import com.demo.repository.NextStuCourseRepository;
import com.demo.service.impl.NextStuCourseServiceImpl;
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

    @Autowired
    NextStuCourseServiceImpl nextStuCourseService;

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/next/course", produces = "application/json; charset=UTF-8")
    public List<Course> getNextCourses(@RequestBody Map<String, String> sno) {
        String s = sno.get("sno");
        List<NextStuCourse> nextStuCourses = new ArrayList<>();
        try {
            nextStuCourses = nextStuCourseRepository.findBySno(s);
        } catch (Exception e){
            return null;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i< nextStuCourses.size();i++) {
            list.add(nextStuCourses.get(i).getCno());
        }
        if(list.size() == 0 ){
            return null;
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
        ResultVO resultVO = new ResultVO();
        try {
            nextStuCourseService.delOne(sno, cno);
        } catch (Exception e) {
            resultVO.setCno(cno);
            resultVO.setCode(500);
            resultVO.setMsg("删除失败");
            resultVO.setCourse(courseRepository.getOne(cno));
            return resultVO;
        }
        resultVO.setCourse(courseRepository.getOne(cno));
        resultVO.setMsg("删除成功");
        resultVO.setCode(200);
        resultVO.setCno(cno);
        return resultVO;
    }


}
