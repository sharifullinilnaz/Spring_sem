package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String name;
    private String email;
    private String password;
    private int year;
    private String nickname;
    private String city;
    private String surname;
}
