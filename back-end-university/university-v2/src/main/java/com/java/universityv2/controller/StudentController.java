package com.java.universityv2.controller;

import com.java.universityv2.dto.StudentRequestDto;
import com.java.universityv2.dto.StudentResponseDto;
import com.java.universityv2.model.Student;
import com.java.universityv2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("{page}/{pageSize}")
    public ResponseEntity<Page<StudentResponseDto>> listStudent(@PathVariable int page, @PathVariable int pageSize){
        Page page1 = studentService.findAll(page, pageSize);
        return new ResponseEntity<>(page1, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<StudentResponseDto> create(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto responseDto = studentService.create(studentRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
