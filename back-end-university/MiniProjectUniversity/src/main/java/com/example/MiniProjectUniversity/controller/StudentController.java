package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.model.Student;
import com.example.MiniProjectUniversity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.NewThreadAction;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student dataStudent = service.createStudent(student);
        return new ResponseEntity<>(dataStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getData")
    public List<Student> findAll(){
        return service.findAllStudent();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> findById(@PathVariable String id){
        Student student = service.findStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable String id){
        return service.deleteStudent(id);
    }

}
