package com.example.MiniProjectUniversity.repository;

import com.example.MiniProjectUniversity.dto.ReportStudent;
import com.example.MiniProjectUniversity.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, String> {

    @Query(value = "select * from trx_exam", nativeQuery = true)
    public List<Exam> findAllExam();

    @Query(value = "select * from trx_exam e where e.exam_code = : id", nativeQuery = true)
    public Optional<Exam> findByIdExam(@PathVariable String id);

    @Query(value = "select a.student_id_number as studentIdNumber, a.full_name as fullName, " +
            "b.semester as semester, b.name_subject as subject,\n" +
            "max(case when d.exam_level='Quiz' then c.score end) as quiz,\n" +
            "max(case when d.exam_level='Midterm Exam' then c.score end) as midtermExam,\n" +
            "max(case when d.exam_level='Final Exam' then c.score end) as finalExam, \n" +
            "SUM(c.score/3) as total, \n" +
            "case \n" +
            "\twhen sum(c.score/3) > 89 AND sum(c.score/3)< 101 then 'A'\n" +
            "\twhen sum(c.score/3) > 79 AND sum(c.score/3)< 90 then 'B'\n" +
            "\twhen sum(c.score/3) > 69 AND sum(c.score/3)< 80 then 'C'\n" +
            "\twhen sum(c.score/3) > 59 AND sum(c.score/3)< 70 then 'D'\n" +
            "\telse 'E'\n" +
            "end as grade\n" +
            "from mst_student a inner join trx_exam c\n" +
            "on a.id_student=c.id_student inner join\n" +
            "mst_subject b on b.code_subject=c.code_subject inner join\n" +
            "mst_exam_level d on d.exam_level_code=c.exam_level_code\n" +
            "group by a.student_id_number, a.full_name, b.semester, b.name_subject", nativeQuery = true)
    public List<ReportStudent> reportStudent();

}
