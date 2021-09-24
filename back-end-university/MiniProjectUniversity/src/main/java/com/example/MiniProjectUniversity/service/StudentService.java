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
        Student student1 = checkStudentIdNumber(student);
        if (student1 == null){
            return student1 = null;
        }
        repository.save(student1);
        return student1;
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

    @Transactional(readOnly = true)
    public Student findStudentById(String id){
        return repository.getById(id);
    }

    private Student checkStudentIdNumber(Student student) {
        Student student2 = null;
        List<Student> list = repository.findAll();
        for (Student std : list){
            if(std.getStudentIdNumber() == student.getStudentIdNumber()){
                student2 = null;
            }
        }
        Student student1 = insertStudentFromRequest(student);
        student2 = student1;
        return student2;
    }

    private Student insertStudentFromRequest(Student student) {
        Student student1 = new Student();
        if (student.getIdStudent() == null || student.getIdStudent().equals("")) {
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
