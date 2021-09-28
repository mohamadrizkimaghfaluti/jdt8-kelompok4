package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.model.ExamLevel;
import com.example.MiniProjectUniversity.service.ExamLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exam-level")
public class ExamLevelController {

    @Autowired
    private ExamLevelService service;

    @GetMapping
    public ResponseEntity<List<ExamLevel>> findAll(){
        List<ExamLevel> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
