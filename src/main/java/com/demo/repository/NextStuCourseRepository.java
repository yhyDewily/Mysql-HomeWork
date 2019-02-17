package com.demo.repository;

import com.demo.dataobject.Course;
import com.demo.dataobject.NextStuCourse;
import com.demo.dataobject.SnoCnoMultilKeyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NextStuCourseRepository extends JpaRepository<NextStuCourse, SnoCnoMultilKeyClass> {

    List<NextStuCourse> findBySno (String sno);

    NextStuCourse findBySnoAndCno(String sno, String cno);

//    void deleteBySnoAndCno (String sno, String cno);
}
