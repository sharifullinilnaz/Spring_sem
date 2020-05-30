package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.ArticleDto;
import ru.itis.springbootdemo.dto.CommentDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.Comment;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.ArticlesRepository;
import ru.itis.springbootdemo.repositories.CommentsRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public void add(CommentDto form, User user, Article article) {
        Comment comment = Comment.builder()
                .text(form.getText())
                .date(LocalDateTime.now())
                .build();
        commentsRepository.save(comment);
        comment.setArticle(article);
        comment.setUser(user);
        usersRepository.save(user);
        articlesRepository.save(article);
    }

    @Override
    public List<Comment> getAllCommentsToArticle(Long articleId) {
        return commentsRepository.findByArticleId(articleId);
    }
}
