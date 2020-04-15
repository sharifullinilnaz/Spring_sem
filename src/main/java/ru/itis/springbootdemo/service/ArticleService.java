package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.ArticleDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.User;

import java.util.List;

public interface ArticleService {
    void add(ArticleDto form, User user, String photoUrl);
    List<Article> getArticles();
    Article getConcreteArticle(Long id);
}
