package com.example.MiniProjectUniversity.model;


import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @NotNull
    @Column(name = "code_subject", length = 25)
    private String codeSubject;

    @NotNull
    @Column(name = "name_subject", length = 100)
    private String nameSubject;

    @NotNull
    @Column(name = "sks")
    private int sks;

    @NotNull
    @Column(name = "semester")
    private int semester;


    public String getCodeSubject() {return codeSubject;}

    public void setCodeSubject(String codeSubject) {this.codeSubject = codeSubject;}

    public String getNameSubject() {return nameSubject;}

    public void setNameSubject(String nameSubject) {this.nameSubject = nameSubject;}

    public int getSks() {return sks;}

    public void setSks(int sks) {this.sks = sks;}

    public int getSemester() {return semester;}

    public void setSemester(int semester) {this.semester = semester;}
}

