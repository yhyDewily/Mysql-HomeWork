package com.demo.repository;

import com.demo.dataobject.SnoCnoMultilKeyClass;
import com.demo.dataobject.StudentsCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsCourseRepository extends JpaRepository<StudentsCourse, SnoCnoMultilKeyClass> {

    @Query(value = "SELECT * FROM demo.sc WHERE SNO=?1", nativeQuery = true)
    List<StudentsCourse> findBySno(String sno);

    @Query(value = "SELECT * FROM  demo.sc WHERE CNO=?1 ", nativeQuery = true)
    List<StudentsCourse> findByCnoIn(String cno);

    @Query(value = "SELECT * FROM demo.sc WHERE SNO=?1 AND CNO=?2", nativeQuery = true)
    StudentsCourse findBySnoAndCno(String sno, String cno);
}
