package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;

public interface EditProfileService {
    void editProfile(UserDto changedUser, User user);
}
