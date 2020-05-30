package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.CommentDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.Comment;
import ru.itis.springbootdemo.models.User;

import java.util.List;

public interface CommentService {
    void add(CommentDto form, User user, Article article);
    void delete(Long id);
    List<Comment> getAllCommentsToArticle(Long articleId);
    Comment getById(Long id);
}
