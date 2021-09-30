package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.dto.ExamRequestDto;
import com.example.MiniProjectUniversity.dto.ExamResponseDto;
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

    @GetMapping("/exam-list")
    public ResponseEntity<List<ExamResponseDto>> findAllExam(){
        List<ExamResponseDto> list = service.findAllExam();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Exam> create(@RequestBody ExamRequestDto examRequestDto){
        Exam exam = service.create(examRequestDto);
        return new ResponseEntity<>(exam, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Exam> update(@RequestBody ExamRequestDto examRequestDto){
        Exam exam = service.update(examRequestDto);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<ExamResponseDto> findById(@PathVariable String id){
        ExamResponseDto dto = service.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        Object dto = service.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
