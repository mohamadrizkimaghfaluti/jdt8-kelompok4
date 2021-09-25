package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.model.Subject;
import com.example.MiniProjectUniversity.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping
    public ResponseEntity<List<Subject>> findAll(){
        List<Subject> subjectList = service.findAllSubject();
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }

    @GetMapping("getIdSubject/{id}")
    public ResponseEntity<Optional> findById(@PathVariable String id) {
        Optional optional = service.findById(id);
        return new ResponseEntity<>(optional, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Subject> create(@RequestBody Subject subject){
        Subject subject1 = service.create(subject);
        return new ResponseEntity<>(subject1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Subject> update(@RequestBody Subject subject){
        Subject subject1 = service.update(subject);
        return new ResponseEntity<>(subject1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        Object data = service.delete(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
