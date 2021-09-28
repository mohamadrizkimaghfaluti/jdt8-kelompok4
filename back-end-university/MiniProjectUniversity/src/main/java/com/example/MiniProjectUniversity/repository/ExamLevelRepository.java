package com.example.MiniProjectUniversity.repository;

import com.example.MiniProjectUniversity.model.ExamLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamLevelRepository extends JpaRepository<ExamLevel, String> {
}
