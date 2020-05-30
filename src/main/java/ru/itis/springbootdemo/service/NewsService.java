package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.NewsDto;
import ru.itis.springbootdemo.models.News;
import ru.itis.springbootdemo.models.User;

import java.util.List;

public interface NewsService {
    void add(NewsDto form, User user, String photoUrl);
    List<News> getNews();
    News getConcreteNews(Long id);
    List<News> getAllAuthorNews(Long authorId);
}