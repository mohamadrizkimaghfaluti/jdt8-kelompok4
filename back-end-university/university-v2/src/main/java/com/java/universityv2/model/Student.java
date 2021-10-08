package com.java.universityv2.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mst_student")
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

}
