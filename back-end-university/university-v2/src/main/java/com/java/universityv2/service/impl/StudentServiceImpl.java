package com.java.universityv2.service.impl;

import com.java.universityv2.dto.StudentRequestDto;
import com.java.universityv2.dto.StudentResponseDto;
import com.java.universityv2.model.Student;
import com.java.universityv2.repository.StudentRepository;
import com.java.universityv2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<Student> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize,
                Sort.by(Sort.Order.asc("fullName")));
        return studentRepository.findAll(pageable);
    }

    @Override
    public StudentResponseDto create(StudentRequestDto studentRequestDto) {
        Student student = buildModelFromRequest(studentRequestDto);
        studentRepository.save(student);
        return buildResponseFromModel(student);
    }

    private StudentResponseDto buildResponseFromModel(Student student) {
        StudentResponseDto responseDto = StudentResponseDto.builder()
                .idStudent(student.getIdStudent())
                .studentIdNumber(student.getStudentIdNumber())
                .fullName(student.getFullName())
                .address(student.getAddress())
                .email(student.getEmail())
                .phone(student.getPhone())
                .studyProgram(student.getStudyProgram())
                .build();
        return responseDto;
    }

    private Student buildModelFromRequest(StudentRequestDto studentRequestDto) {
        String id = UUID.randomUUID().toString();
        Student student = Student.builder()
                .idStudent(id)
                .studentIdNumber(studentRequestDto.getStudentIdNumber())
                .fullName(studentRequestDto.getFullName())
                .address(studentRequestDto.getAddress())
                .email(studentRequestDto.getEmail())
                .phone(studentRequestDto.getPhone())
                .studyProgram(studentRequestDto.getStudyProgram())
                .build();
        return student;
    }
}
