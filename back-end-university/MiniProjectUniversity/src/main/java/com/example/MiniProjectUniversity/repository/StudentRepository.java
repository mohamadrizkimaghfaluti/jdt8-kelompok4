package com.example.MiniProjectUniversity.repository;

import com.example.MiniProjectUniversity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
