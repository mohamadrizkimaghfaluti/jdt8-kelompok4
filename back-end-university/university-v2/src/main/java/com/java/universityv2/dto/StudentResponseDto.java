package com.java.universityv2.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@Builder
public class StudentResponseDto {

    private String idStudent;
    private String studentIdNumber;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private String studyProgram;

}
