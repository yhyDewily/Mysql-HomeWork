package com.demo.repository;

import com.demo.dataobject.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findByCnoIn (List<String> cnoList);

    List<Course> findByCnoNotIn ( List<String> cnoList);

    Course findByCnoAndCname(String cno, String cname);

    Course findByCname(String cname);
}
