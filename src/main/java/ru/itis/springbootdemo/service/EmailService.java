package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.models.User;

public interface EmailService {
    void sendMail(String subject, User user, String email);
}
