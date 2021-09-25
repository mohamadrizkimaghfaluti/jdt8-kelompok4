package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.model.Subject;
import com.example.MiniProjectUniversity.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Transactional(readOnly = true)
    public List<Subject> findAllSubject(){
        return repository.findAll();
    }

    @Transactional(rollbackFor = Throwable.class)
    public Subject create(Subject subject){
        Subject subject1 = insertDataSubject(subject);
        repository.save(subject1);
        return subject1;
    }

    @Transactional(rollbackFor = Throwable.class)
    public Subject update(Subject subject){
        Subject subject1 = repository.save(subject);
        return subject1;
    }

    @Transactional(rollbackFor = Throwable.class)
    public Object delete(String id){
        repository.deleteById(id);
        return "delete suksess";
    }

    @Transactional(readOnly = true)
    public Optional findById(String id){
        Optional optional = repository.findById(id);
        return optional;
    }

    private Subject insertDataSubject(Subject subject) {
        Subject subject1 = new Subject();
        subject1.setCodeSubject(String.valueOf(randomNumber()));
        subject1.setNameSubject(subject.getNameSubject());
        subject1.setSks(subject.getSks());
        subject1.setSemester(subject.getSemester());
        return subject1;
    }

    private int randomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        int k = Integer.parseInt(String.format("%08d", number));
        return k;
    }

}
