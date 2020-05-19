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
import java.util.Optional;

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
    public void add(ArticleDto form, User user, String photoUrl) {
        Article article = Article.builder()
                .name(form.getName())
                .geolocation(form.getGeolocation())
                .photoPath(photoUrl)
                .date(LocalDateTime.now())
                .text(form.getText())
                .build();
        articlesRepository.save(article);
        article.setUser(user);
        usersRepository.save(user);
    }

    @Override
    public Article getConcreteArticle(Long id) {
        return articlesRepository.getOne(id);
    }

    @Override
    public List<Article> getAllAuthorArticles(Long authorId) {
        return articlesRepository.findByUserId(authorId);
    }

    @Override
    public void deleteArticle(Long articleId) {
        articlesRepository.deleteById(articleId);
    }

}