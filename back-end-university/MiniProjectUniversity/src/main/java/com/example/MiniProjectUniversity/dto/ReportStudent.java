package com.example.MiniProjectUniversity.dto;

public interface ReportStudent {

    String getStudentIdNumber();
    String getFullName();
    String getSubject();
    Long getSemester();
    Long getQuiz();
    Long getMidtermExam();
    Long getFinalExam();
    Long getTotal();
    String getGrade();

}
