package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.model.Student;
import com.example.MiniProjectUniversity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Transactional(rollbackFor = Throwable.class)
    public Student createStudent(Student student){
        Student student1 = buildModelFromRequest(student);
        return repository.save(student1);
    }

    @Transactional(readOnly = true)
    public List<Student> findAllStudent(){
        return repository.findAll();
    }

    @Transactional(rollbackFor = Throwable.class)
    public Object deleteStudent(String id){
        repository.deleteById(id);
        return "delete success";
    }

    private Student buildModelFromRequest(Student student) {
        Student student1 = new Student();
        if (student.getIdStudent() == null || student.getIdStudent().equals("")){
            String id = UUID.randomUUID().toString();

            student1.setIdStudent(id);
            student1.setStudentIdNumber(student.getStudentIdNumber());
            student1.setFullName(student.getFullName());
            student1.setAddress(student.getAddress());
            student1.setEmail(student.getEmail());
            student1.setPhone(student.getPhone());
            student1.setStudyProgram(student.getStudyProgram());
        }
        return student1;
    }


}
