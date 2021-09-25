package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.model.Subject;
import com.example.MiniProjectUniversity.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/create")
    public ResponseEntity<Subject> create(@RequestBody Subject subject){
        Subject subject1 = service.create(subject);
        return new ResponseEntity<>(subject1, HttpStatus.CREATED);
    }
}
