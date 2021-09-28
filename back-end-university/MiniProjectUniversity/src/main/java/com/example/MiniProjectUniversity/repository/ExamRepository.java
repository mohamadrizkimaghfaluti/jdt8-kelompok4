package com.example.MiniProjectUniversity.repository;

import com.example.MiniProjectUniversity.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, String> {

    @Query(value = "select s.student_id_number, s.full_name, s.study_program, m.name_subject," +
            "m.semester, l.full_name, e.score, el.exam_level, e.date " +
            "from trx_exam e inner join mst_student s on s.id_student=e.id_student " +
            "inner join mst_lecturer l on e.id_lecturer=l.id_lecturer " +
            "inner join mst_subject m on e.code_subject=m.code_subject " +
            "inner join mst_exam_level el on e.exam_level_code=el.exam_level_code", nativeQuery = true)
    public List<Exam> findAllEx();

    @Query(value = "select * from trx_exam", nativeQuery = true)
    public List<Exam> findAllExam();

}
