package com.demo.repository;

import com.demo.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findBySdeptIn(String sdept);
}
