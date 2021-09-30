package com.example.MiniProjectUniversity.service;

import com.example.MiniProjectUniversity.dto.ReportDto;
import com.example.MiniProjectUniversity.model.Exam;
import com.example.MiniProjectUniversity.model.ExamLevel;
import com.example.MiniProjectUniversity.model.Student;
import com.example.MiniProjectUniversity.model.Subject;
import com.example.MiniProjectUniversity.repository.ExamLevelRepository;
import com.example.MiniProjectUniversity.repository.ExamRepository;
import com.example.MiniProjectUniversity.repository.StudentRepository;
import com.example.MiniProjectUniversity.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamLevelRepository examLevelRepository;

    public List<ReportDto> reportStudent() {
        List<Subject> subjectList = subjectRepository.findAll();
        List<Student> studentList = studentRepository.findAll();
        List<Exam> examList = examRepository.findAllExam();
        List<ReportDto> reportDtos = new ArrayList<>();
        ReportDto reportDto = new ReportDto();
        for (Student student:studentList){
            for (Exam exam : examList){
                if (student.getIdStudent().equals(exam.getStudent().getIdStudent())){
                    for (Subject subject:subjectList){
                        if (subject.getCodeSubject().equals(exam.getSubject().getCodeSubject())){
                            reportDto = buildReportDtoFromExam(exam);
                            reportDtos.add(reportDto);
                        }
                    }
                }
            }
        }
        return reportDtos;
    }

    private ReportDto buildReportDtoFromExam(Exam exam) {
        int quiz = 0;
        int midtermExam = 0;
        int finalExam = 0;
        int total;
        String grade="";

        List<ExamLevel> examLevels = examLevelRepository.findAll();
        for (ExamLevel examLevel : examLevels){
            if (exam.getExamLevel().getExamLevelCode().equals("K001")){
                quiz = exam.getScore();
            }
            else if (exam.getExamLevel().getExamLevelCode().equals("K002")){
                midtermExam = exam.getScore();
            }
            else if (exam.getExamLevel().getExamLevelCode().equals("K003")){
                finalExam = exam.getScore();
            }
        }

        total = (quiz+midtermExam+finalExam)/3;
        if (total > 89 && total < 101) {
            grade = "A";
        }
        else if (total > 79 && total < 90){
            grade = "B";
        }
        else if (total > 69 && total < 80){
            grade = "C";
        }
        else if (total > 59 && total < 70){
            grade = "D";
        } else {
            grade = "E";
        }

        ReportDto reportDto = new ReportDto();
        reportDto.setStudentIdNumber(exam.getStudent().getStudentIdNumber());
        reportDto.setFullName(exam.getStudent().getFullName());
        reportDto.setSemester(exam.getSubject().getSemester());
        reportDto.setSubject(exam.getSubject().getNameSubject());
        reportDto.setQuiz(quiz);
        reportDto.setMidtermExam(midtermExam);
        reportDto.setFinalExam(finalExam);
        reportDto.setTotal(total);
        reportDto.setGrade(grade);
        return reportDto;
    }
}