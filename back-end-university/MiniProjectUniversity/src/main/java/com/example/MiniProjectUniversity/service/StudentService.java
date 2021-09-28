package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.model.Student;
import com.example.MiniProjectUniversity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Transactional(rollbackFor = Throwable.class)
    public Boolean createStudent(Student student){
        Student student1 = checkStudentIdNumber(student);
        if (student1 == null){
            return false;
        }
        repository.save(student1);
        return true;
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
    public Optional findStudentById(String id){
        return repository.findById(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    public Student updateStudent(Student student){
        return repository.save(student);
    }

    private Student checkStudentIdNumber(Student student) {
        List<Student> list = repository.findAll();
        for (Student std: list){
            if (std.getStudentIdNumber().equals(student.getStudentIdNumber())){
                return null;
            }
        }
        Student dataStudent = insertStudentFromRequest(student);
        return dataStudent;
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
