package com.example.MiniProjectUniversity.controller;

import com.example.MiniProjectUniversity.model.Lecturer;
import com.example.MiniProjectUniversity.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    private LecturerService service;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Lecturer lecturer) {
        Boolean dataLecturer = service.createLecturer(lecturer);
        if (dataLecturer.equals(true)) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Lecturer>> findAll() {
        List<Lecturer> list = service.findAllLecturer();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Lecturer>> findById(@PathVariable String id){
        Optional optional = service.findLecturerById(id);
        return new ResponseEntity<>(optional, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Lecturer> update(@RequestBody Lecturer lecturer){
        Lecturer lct = service.updateLecturer(lecturer);
        return new ResponseEntity<>(lct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public Object delete(@PathVariable("id") String id){
        service.deleteLecturer(id);
        return true;
    }
}
