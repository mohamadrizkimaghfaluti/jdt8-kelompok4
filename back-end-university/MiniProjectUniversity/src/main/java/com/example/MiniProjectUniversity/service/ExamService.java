package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.model.Exam;
import com.example.MiniProjectUniversity.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository repository;

}
