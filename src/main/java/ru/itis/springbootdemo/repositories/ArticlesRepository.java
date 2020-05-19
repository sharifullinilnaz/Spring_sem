package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springbootdemo.models.Article;


import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * FROM articles ORDER BY date DESC",
            nativeQuery = true)
    List<Article> findAll();
    Optional<Article> findById(Long id);
    @Query(value = "SELECT * FROM articles WHERE user_id = :authorId ORDER BY date DESC",
            nativeQuery = true)
    List<Article> findByUserId(Long authorId);
    @Modifying
    @Query(value = "DELETE FROM comments WHERE comments.article_id = :id ;" + "DELETE FROM articles WHERE id = :id ;", nativeQuery = true)
    void deleteById(Long id);
}




