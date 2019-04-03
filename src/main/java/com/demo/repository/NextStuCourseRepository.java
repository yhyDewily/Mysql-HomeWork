package com.demo.repository;

import com.demo.dataobject.Course;
import com.demo.dataobject.NextStuCourse;
import com.demo.dataobject.SnoCnoMultilKeyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NextStuCourseRepository extends JpaRepository<NextStuCourse, SnoCnoMultilKeyClass> {

    @Query(value = "SELECT * FROM demo.nsc WHERE SNO =?1", nativeQuery = true)
    List<NextStuCourse> findBySno (String sno);

    @Query(value = "SELECT * FROM demo.nsc WHERE SNO=?1 AND CNO=?2", nativeQuery = true)
    NextStuCourse findBySnoAndCno(String sno, String cno);

//    void deleteBySnoAndCno (String sno, String cno);
}
