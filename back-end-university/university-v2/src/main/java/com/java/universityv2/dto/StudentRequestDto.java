package com.java.universityv2.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentRequestDto {

    private String idStudent;
    private String studentIdNumber;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private String studyProgram;

}
