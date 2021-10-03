package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.dto.ReportStudent;
import com.example.MiniProjectUniversity.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<List<ReportStudent>> reportStudent(){
        List<ReportStudent> o = reportService.reportStudent();
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}
