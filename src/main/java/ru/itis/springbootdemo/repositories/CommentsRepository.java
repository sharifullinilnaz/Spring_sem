package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springbootdemo.models.Comment;


import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comments WHERE comments.article_id = :articleId ORDER BY date DESC",
            nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);
    List<Comment> findByUserId(Long authorId);
}