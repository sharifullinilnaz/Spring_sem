package ru.itis.springbootdemo.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ProfileForm {
    @Email(message = "{errors.incorrect.email}")
    private String email;

    @Size(min = 2, message = "{errors.short.name}")
    private String name;

    @Size(min = 2, message = "{errors.short.surname}")
    private String surname;

    @Size(min = 2, message = "{errors.short.city}")
    private String city;

    @Size(min = 5, message = "{errors.short.nickname}")
    private String nickname;


}

