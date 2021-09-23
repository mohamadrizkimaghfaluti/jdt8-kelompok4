package com.example.MiniProjectUniversity.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @NotNull
    @Column(name = "id_student")
    private String idStudent;

    @NotNull
    @Column(name = "student_id_number", length = 20)
    private String studentIdNumber;

    @NotNull
    @Column(name = "full_name", length = 100)
    private String fullName;

    @NotNull
    @Column(name = "address", length = 200)
    private String address;

    @NotNull
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @Column(name = "phone", length = 15)
    private String phone;

    @NotNull
    @Column(name = "study_program", length = 50)
    private String studyProgram;

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }
}
