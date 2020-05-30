package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springbootdemo.models.News;


import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(value = "SELECT * FROM news ORDER BY date DESC",
            nativeQuery = true)
    List<News> findAll();

    Optional<News> findById(Long id);

    List<News> findByUserId(Long authorId);
}