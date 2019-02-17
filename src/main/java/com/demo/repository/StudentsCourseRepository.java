package com.demo.repository;

import com.demo.dataobject.SnoCnoMultilKeyClass;
import com.demo.dataobject.StudentsCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsCourseRepository extends JpaRepository<StudentsCourse, SnoCnoMultilKeyClass> {

    List<StudentsCourse> findBySno(String sno);

    List<StudentsCourse> findByCnoIn(String cno);


    StudentsCourse findBySnoAndCno(String sno, String cno);
}
