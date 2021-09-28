package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.dto.ExamRequestDto;
import com.example.MiniProjectUniversity.model.Exam;
import com.example.MiniProjectUniversity.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("exam")
public class ExamController {

    @Autowired
    private ExamService service;

    @GetMapping
    public ResponseEntity<List<Exam>> findAll(){
        List<Exam> examList = service.findAll();
        return new ResponseEntity<>(examList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Exam> create(@RequestBody ExamRequestDto examRequestDto){
        Exam exam1 = service.create(examRequestDto);
        return new ResponseEntity<>(exam1, HttpStatus.CREATED);
    }

}
