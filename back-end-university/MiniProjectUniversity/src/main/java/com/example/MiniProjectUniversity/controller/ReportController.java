package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.dto.ReportDto;
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
    public ResponseEntity<List<ReportDto>> reportStudent(){
        List<ReportDto> reportDto = reportService.reportStudent();
        return new ResponseEntity<>(reportDto, HttpStatus.OK);
    }
}
