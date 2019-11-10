package com.syriatel.bpm.springtest.repo;

import com.syriatel.bpm.springtest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Students extends JpaRepository<Student,Long> {

    @Query("select s from Student s where id =: id")
    public List<Student> findStudentByPop(Long id);

}
