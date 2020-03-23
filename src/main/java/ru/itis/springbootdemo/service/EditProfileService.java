package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.models.User;

public interface EditProfileService {
    void editProfile(String name, String surname, String city, String email, String nickname, User user);
}
