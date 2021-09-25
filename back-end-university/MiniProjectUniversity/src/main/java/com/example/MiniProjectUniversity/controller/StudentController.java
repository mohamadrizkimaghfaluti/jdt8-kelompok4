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
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Student student){
        Boolean dataStudent = service.createStudent(student);
        if (dataStudent.equals(true)){
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getData")
    public List<Student> findAll(){
        return service.findAllStudent();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable String id){
        return new ResponseEntity<>(service.findStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student){
        Student std = service.updateStudent(student);
        return new ResponseEntity<>(std, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable("id") String id){
        service.deleteStudent(id);
        return true;
    }

}
