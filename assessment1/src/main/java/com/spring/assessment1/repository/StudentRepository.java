package com.spring.assessment1.repository;

import com.spring.assessment1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select id from student", nativeQuery = true)
    List<Long> fetchAllIdsOfUsers();

    @Query("from Student where id=:id")
    public Student findUserById(@Param("id") long id);
}
