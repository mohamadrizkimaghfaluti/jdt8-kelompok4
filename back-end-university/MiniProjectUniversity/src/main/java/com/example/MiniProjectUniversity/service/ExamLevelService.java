package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.model.ExamLevel;
import com.example.MiniProjectUniversity.repository.ExamLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamLevelService {

    @Autowired
    private ExamLevelRepository repository;

    public List<ExamLevel> findAll(){
        List<ExamLevel> list = repository.findAll();
        return list;
    }

}
