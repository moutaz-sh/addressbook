package com.syriatel.bpm.springtest.controllers;

import com.syriatel.bpm.springtest.entity.Student;
import com.syriatel.bpm.springtest.repo.Students;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private  final Students students;

    public StudentController(Students students) {
        this.students = students;
    }
    @GetMapping
    public List<Student> findAll(){return this.students.findAll();}
    @PostMapping("/pop")
    public void pop(@RequestBody Student student){
        student.getName();
        student.getPop();
       this.students.save(student);
    }
    @GetMapping("/sos")
    public String sos(@PathVariable("name") String name){
        return name;
    }



}

