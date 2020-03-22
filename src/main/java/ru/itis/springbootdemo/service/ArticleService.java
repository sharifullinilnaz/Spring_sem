package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.ArticleDto;
import ru.itis.springbootdemo.models.User;

public interface ArticleService {
    void add(ArticleDto form, User user);
}
