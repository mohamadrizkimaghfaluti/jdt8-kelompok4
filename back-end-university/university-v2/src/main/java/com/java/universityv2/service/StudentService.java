package com.java.universityv2.service;

import com.java.universityv2.dto.StudentRequestDto;
import com.java.universityv2.dto.StudentResponseDto;
import com.java.universityv2.model.Student;
import org.springframework.data.domain.Page;

public interface StudentService {

    public Page<Student> findAll(int page, int pageSize);

    StudentResponseDto create(StudentRequestDto studentRequestDto);
}
