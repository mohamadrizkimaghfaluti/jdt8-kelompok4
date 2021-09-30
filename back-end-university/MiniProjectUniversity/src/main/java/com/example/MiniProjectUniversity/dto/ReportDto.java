package com.example.MiniProjectUniversity.dto;

public class ReportDto {

    private String studentIdNumber;
    private String fullName;
    private String subject;
    private int semester;
    private int quiz;
    private int midtermExam;
    private int finalExam;
    private int total;
    private String grade;

    public String getStudentIdNumber() {
        return studentIdNumber;
    }

    public void setStudentIdNumber(String studentIdNumber) {
        this.studentIdNumber = studentIdNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getMidtermExam() {
        return midtermExam;
    }

    public void setMidtermExam(int midtermExam) {
        this.midtermExam = midtermExam;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        grade = grade;
    }
}
