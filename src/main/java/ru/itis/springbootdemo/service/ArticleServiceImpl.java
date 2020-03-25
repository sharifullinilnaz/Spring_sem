package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.ArticleDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.ArticlesRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Article> getArticles() {
        return articlesRepository.findAll();
    }

    @Override
    public void add(ArticleDto form, User user) {
        Article article = Article.builder()
                .name(form.getName())
                .geolocation(form.getGeolocation())
                .photoPath(form.getPhotoPath())
                .date(LocalDateTime.now())
                .text(form.getText())
                .build();
        article = articlesRepository.save(article);
        article.setUser(user);
        usersRepository.save(user);
    }
}