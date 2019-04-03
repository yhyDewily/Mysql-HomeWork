package com.demo.controller;

import com.demo.VO.CourseVO;
import com.demo.VO.LoginInfoVO;
import com.demo.VO.ResultVO;
import com.demo.VO.StuCourseVO;
import com.demo.dataobject.Course;
import com.demo.dataobject.NextStuCourse;
import com.demo.dataobject.StudentsCourse;
import com.demo.repository.CourseRepository;
import com.demo.repository.NextStuCourseRepository;
import com.demo.repository.StudentsCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    StudentsCourseRepository studentsCourseRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    NextStuCourseRepository nextStuCourseRepository;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/course",  method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public List<Course> getCourses(@RequestBody LoginInfoVO loginInfoVO) {
        String sno = loginInfoVO.getSno();
        return getSemesterCoursesUtil(sno);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/course/unchoose",  method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public List<Course> getUnchoosenCourses(@RequestBody LoginInfoVO loginInfoVO) {
        String sno = loginInfoVO.getSno();
        return getUnchooseCoursesUtil(sno);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/course/search", method = RequestMethod.POST, produces = "application/json; charset=UTF-8" )
    public Course searchCourse(@RequestBody CourseVO courseVO) {
        String cno = courseVO.getCno();
        String cname = courseVO.getCname();
        if (cno == null) cno = "";
        if (cname == null) cname ="";
        if(!cno.equals("") && !cname.equals("")){
            try {
                courseRepository.findByCnoAndCname(cno, cname);
            } catch (Exception e){
                return null;
            }
            return courseRepository.findByCnoAndCname(cno, cname);
        } else if (!cno.equals("") && cname.equals("")) {
            try {
                courseRepository.getOne(cno);
            } catch (Exception e){
                return null;
            }
            return courseRepository.getOne(cno);
        } else if (cno.equals("")  && !cname.equals("")) {
            try {
                courseRepository.findByCname(cname);
            } catch (Exception e){
                return null;
            }
            return courseRepository.findByCname(cname);
        } else {
            return null;
        }
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/api/course/add", produces = "application/json; charset=UTF-8")
    public ResultVO addCourse(@RequestBody StuCourseVO stuCourseVO) {
        String sno = stuCourseVO.getSno();
        String cno = stuCourseVO.getCno();
        NextStuCourse nextStuCourse = new NextStuCourse(sno,cno);
        ResultVO resultVO = new ResultVO();
        try {
            nextStuCourseRepository.save(nextStuCourse);
        } catch (Exception e) {
            resultVO.setMsg("选课失败");
            resultVO.setCode(500);
            resultVO.setCno(cno);
            return resultVO;
        }
        resultVO.setMsg("选课成功");
        resultVO.setCode(200);
        resultVO.setCno(cno);
        resultVO.setCourse(courseRepository.getOne(cno));
        return resultVO;
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/course/update", produces = "application/json; charset=UTF-8")
    public List<Object> updateCourses(@RequestBody String sno) {
        List<NextStuCourse> nextSemCourses = nextStuCourseRepository.findBySno(sno);
        List<StudentsCourse> studentsCourses = studentsCourseRepository.findBySno(sno);
        List<Object> result = new ArrayList<>();
        result.add(nextSemCourses);
        result.add(studentsCourses);
        return result;
    }

    public List<Course> getSemesterCoursesUtil(String sno) {
        List<StudentsCourse> courseList = studentsCourseRepository.findBySno(sno);
        List<String> cnoList = new ArrayList<>();
        for( StudentsCourse course : courseList) {
            cnoList.add(course.getCno());
        }
        if(cnoList.size() == 0) return null;
        List<Course> courses = courseRepository.findByCnoIn(cnoList);
        return courses;
    }

    public List<Course> getUnchooseCoursesUtil(String sno) {
        List<NextStuCourse> nextStuCourses = nextStuCourseRepository.findBySno(sno);
        List<StudentsCourse> courseList = studentsCourseRepository.findBySno(sno);
        List<String> cnoList = new ArrayList<>();
        for( StudentsCourse course : courseList) {
            cnoList.add(course.getCno());
        }
        for (NextStuCourse course : nextStuCourses) {
            cnoList.add(course.getCno());
        }
        if(cnoList.size() == 0)
            return courseRepository.findAll();
        List<Course> courses = courseRepository.findByCnoNotIn(cnoList);
        return courses;
    }
}
