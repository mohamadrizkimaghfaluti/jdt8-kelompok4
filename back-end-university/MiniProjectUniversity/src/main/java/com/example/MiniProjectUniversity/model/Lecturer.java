package com.example.MiniProjectUniversity.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @NotNull
    @Column(name = "id_lecturer")
    private String idLecturer;

    @NotNull
    @Column(name = "lecturer_id_number", length = 20)
    private String lecturerIdNumber;

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

    public String getIdLecturer() {return idLecturer;}

    public void setIdLecturer(String idLecturer) {this.idLecturer = idLecturer;}

    public String getLecturerIdNumber() {return lecturerIdNumber;}

    public void setLecturerIdNumber(String lecturerIdNumber) {this.lecturerIdNumber = lecturerIdNumber;}

    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}
}
