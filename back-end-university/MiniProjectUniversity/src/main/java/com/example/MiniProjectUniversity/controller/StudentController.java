package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.model.Student;
import com.example.MiniProjectUniversity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        Student dataStudent = service.createStudent(student);
        return dataStudent;
    }

    @GetMapping("/getData")
    public List<Student> findAll(){
        return service.findAllStudent();
    }

    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable String id){
        return service.deleteStudent(id);
    }

}
