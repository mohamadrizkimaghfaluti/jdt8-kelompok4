package com.example.MiniProjectUniversity.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_exam_level")
public class ExamLevel {

    @Id
    @NotNull
    @Column(name = "exam_level_code", length = 10)
    private String examLevelCode;

    @NotNull
    @Column(name = "exam_level",length = 50)
    private String examLevel;

    public String getExamLevelCode() {
        return examLevelCode;
    }

    public void setExamLevelCode(String examLevelCode) {
        this.examLevelCode = examLevelCode;
    }

    public String getExamLevel() {
        return examLevel;
    }

    public void setExamLevel(String examLevel) {
        this.examLevel = examLevel;
    }

}
