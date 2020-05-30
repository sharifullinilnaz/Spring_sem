package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.NewsDto;
import ru.itis.springbootdemo.models.News;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.NewsRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<News> getNews() {
        return newsRepository.findAll();
    }

    @Override
    public void add(NewsDto form, User user, String photoUrl) {
        News news = News.builder()
                .title(form.getTitle())
                .photoPath(photoUrl)
                .date(LocalDateTime.now())
                .text(form.getText())
                .build();
        newsRepository.save(news);
        news.setUser(user);
        usersRepository.save(user);
    }

    @Override
    public News getConcreteNews(Long id) {
        Optional<News> newsOptional = newsRepository.findById(id);
        return newsOptional.orElse(null);
    }

    @Override
    public List<News> getAllAuthorNews(Long authorId) {
        return newsRepository.findByUserId(authorId);
    }


}