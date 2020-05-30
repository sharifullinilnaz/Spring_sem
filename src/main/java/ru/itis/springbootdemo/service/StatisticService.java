package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.Comment;

import java.util.List;

public interface StatisticService {

    void giveStatistic(List<Article> articles);
    void giveTopArticleStatistic(List<Comment> comments);
}
