package com.example.MiniProjectUniversity.repository;

import com.example.MiniProjectUniversity.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, String> {

    @Query(value = "select s.student_id_number, ")
    public List<Exam> listExams();

}
