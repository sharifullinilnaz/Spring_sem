package ru.itis.springbootdemo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.repositories.ArticlesRepository;
import ru.itis.springbootdemo.service.StatisticService;

import java.util.List;


@Configuration
@EnableScheduling
@Slf4j
public class CountOfArticlesScheduler {

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Transactional
    @Scheduled(cron = "0 0 10 1 * ?")
    public void run() {
        List<Article> articles = articlesRepository.findAll();
        statisticService.giveStatistic(articles);
    }
}