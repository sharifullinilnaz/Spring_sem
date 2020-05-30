package ru.itis.springbootdemo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.springbootdemo.models.Comment;
import ru.itis.springbootdemo.repositories.CommentsRepository;
import ru.itis.springbootdemo.service.StatisticService;

import java.util.List;


@Configuration
@EnableScheduling
@Slf4j
public class TopArticleScheduler {

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private CommentsRepository commentsRepository;

    @Transactional
    @Scheduled(cron = "0 0 10 1 * ?")
    public void run() {
        List<Comment> comments = commentsRepository.findAll();
        statisticService.giveTopArticleStatistic(comments);
    }
}