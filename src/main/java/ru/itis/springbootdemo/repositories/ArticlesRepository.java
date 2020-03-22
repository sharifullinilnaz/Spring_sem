package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Article;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
}
