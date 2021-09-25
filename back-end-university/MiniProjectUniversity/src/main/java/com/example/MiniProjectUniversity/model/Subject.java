package com.example.MiniProjectUniversity.model;


import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @NotNull
    @Column(name = "code_subject", length = 25)
    private String codeSubject;

    @NotNull
    @Column(name = "name_subject", length = 100)
    private String nameSubject;

    @NotNull
    @Column(name = "sks", length = 10)
    private int Sks;

    @NotNull
    @Column(name = "semester", length = 50)
    private String semester;


    public String getCodeSubject() {return codeSubject;}

    public void setCodeSubject(String codeSubject) {this.codeSubject = codeSubject;}

    public String getNameSubject() {return nameSubject;}

    public void setNameSubject(String nameSubject) {this.nameSubject = nameSubject;}

    public int getSks() {return Sks;}

    public void setSks(int sks) {Sks = sks;}

    public String getSemester() {return semester;}

    public void setSemester(String semester) {this.semester = semester;}
}

