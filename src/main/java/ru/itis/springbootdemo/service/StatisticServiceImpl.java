package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.Comment;
import ru.itis.springbootdemo.models.Statistic;
import ru.itis.springbootdemo.models.StatisticTopArticle;
import ru.itis.springbootdemo.repositories.StatisticsRepository;
import ru.itis.springbootdemo.repositories.StatisticsTopArticleRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticsTopArticleRepository statisticsTopArticleRepository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public void giveStatistic(List<Article> articles) {
        int count = articles.size();
        statisticsRepository.save(Statistic.builder().countOfArticles(count).date(LocalDateTime.now()).build());
    }

    @Override
    public void giveTopArticleStatistic(List<Comment> comments){
        Long topArticle = comments.get(1).getId();
        HashMap<Long, Integer> countOfCommentsMap = new HashMap<>();
        for (Comment c : comments) {
            int countOfComments = 0;
            if (countOfCommentsMap.containsKey(c.getArticle().getId())) {
                countOfComments = countOfCommentsMap.get(c.getArticle().getId()) + 1;
                countOfCommentsMap.put(c.getArticle().getId(), countOfComments);
            } else {
                countOfCommentsMap.put(c.getArticle().getId(), countOfComments);
            }
        }
        for (Long article : countOfCommentsMap.keySet()) {
            if (countOfCommentsMap.get(article) >= countOfCommentsMap.get(topArticle)) {
                topArticle = article;
            }
        }
        statisticsTopArticleRepository.save(StatisticTopArticle.builder().articleId(topArticle).countOfComments(countOfCommentsMap.get(topArticle)).date(LocalDateTime.now()).build());

    }

}