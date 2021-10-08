package com.java.universityv2.repository;

import com.java.universityv2.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, String> {
}
