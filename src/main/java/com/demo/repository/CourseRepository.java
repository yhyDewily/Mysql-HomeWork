package com.demo.repository;

import com.demo.dataobject.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {

    @Query(value = "select * from demo.c WHERE CNO in ?1", nativeQuery = true)
    List<Course> findByCnoIn (List<String> cnoList);

    @Query(value = "select * FROM demo.c WHERE CNO NOT IN ?1 ", nativeQuery = true)
    List<Course> findByCnoNotIn ( List<String> cnoList);

    @Query(value = "SELECT * FROM  demo.c WHERE CNO=?1 AND CNAME=?2", nativeQuery = true)
    Course findByCnoAndCname(String cno, String cname);

    @Query(value = "SELECT * FROM demo.c WHERE CNAME=?1", nativeQuery = true)
    Course findByCname(String cname);

    @Query(value = "select * from demo.c", nativeQuery = true)
    List<Course> findAll();
}
