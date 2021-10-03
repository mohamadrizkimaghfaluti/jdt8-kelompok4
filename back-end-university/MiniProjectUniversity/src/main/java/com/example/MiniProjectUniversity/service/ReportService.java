package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.dto.ReportStudent;
import com.example.MiniProjectUniversity.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ExamRepository examRepository;

    public List<ReportStudent> reportStudent(){
        List<ReportStudent> list = examRepository.reportStudent();
        return list;
    }

}