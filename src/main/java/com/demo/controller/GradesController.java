package com.demo.controller;

import com.demo.VO.GradesVO;
import com.demo.VO.LoginInfoVO;
import com.demo.dataobject.Course;
import com.demo.dataobject.StudentsCourse;
import com.demo.repository.CourseRepository;
import com.demo.repository.StudentsCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GradesController {

    @Autowired
    StudentsCourseRepository studentsCourseRepository;

    @Autowired
    CourseRepository courseRepository;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/grades", method = RequestMethod.POST, produces = "application/json; charset=UTF-8" )
    public List<GradesVO> getGrades(@RequestBody LoginInfoVO loginInfoVO) {
        String sno = loginInfoVO.getSno();
        return setGradesVO(sno);
    }


    public List<GradesVO> setGradesVO (String sno) {
        //获取sc表里的学生成绩课程信息
        List<StudentsCourse> courseList = studentsCourseRepository.findBySno(sno);
        List<String> cnoList = new ArrayList<>();
        for( StudentsCourse course : courseList) {
            cnoList.add(course.getCno());
        }
        //获取所选课程的详细信息
        List<Course> courses = courseRepository.findByCnoIn(cnoList);
        List<GradesVO> grades = new ArrayList<>();
        for(int i = 0; i < courses.size(); i++) {
            GradesVO gradesVO = new GradesVO();
            //防止数据获取不匹配
            String cno = courses.get(i).getCno();
            Course course = courseRepository.getOne(cno);
            StudentsCourse studentsCourse = studentsCourseRepository.findBySnoAndCno(sno, cno);
            //数据拼装
            gradesVO.setCno(cno);
            gradesVO.setCname(course.getCname());
            gradesVO.setCredit(course.getCredit());
            gradesVO.setGrade(studentsCourse.getGrade());
            //将拼装完的数据添加到列表
            grades.add(gradesVO);
        }
        return grades;
    }
}
