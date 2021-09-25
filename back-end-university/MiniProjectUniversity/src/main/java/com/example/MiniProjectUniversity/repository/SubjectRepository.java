package com.example.MiniProjectUniversity.repository;

import com.example.MiniProjectUniversity.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
