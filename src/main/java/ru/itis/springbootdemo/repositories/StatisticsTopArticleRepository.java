package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.StatisticTopArticle;

public interface StatisticsTopArticleRepository extends JpaRepository<StatisticTopArticle, Long> {

}
