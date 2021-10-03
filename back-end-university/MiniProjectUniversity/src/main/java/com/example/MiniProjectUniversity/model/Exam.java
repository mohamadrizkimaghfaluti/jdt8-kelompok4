package com.example.MiniProjectUniversity.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "trx_exam")
public class Exam {

    @Id
    @NotNull
    @Column(name = "exam_code")
    private String examCode;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_lecturer")
    private Lecturer lecturer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "code_subject")
    private Subject subject;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "exam_level_code")
    private ExamLevel examLevel;

    @NotNull
    @Column(name = "score")
    private int score;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ExamLevel getExamLevel() {
        return examLevel;
    }

    public void setExamLevel(ExamLevel examLevel) {
        this.examLevel = examLevel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}