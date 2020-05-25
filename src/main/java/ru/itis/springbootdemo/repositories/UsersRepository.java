package ru.itis.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.models.User;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmCode(String confirmCode);
    List<User> findAllByNameContainsIgnoreCase(String name);

    @Query("from User user where " +
            "upper(user.nickname) like concat('%', upper(:query), '%') or " +
            "upper(user.name) like concat('%', upper(:query), '%')")
    Page<User> search(@Param("query") String query,Pageable pageable);

    @Modifying
    @Query(value =  "DELETE FROM comments WHERE comments.article_id in (SELECT id from articles WHERE articles.user_id = :id);" + "DELETE FROM comments WHERE user_id = :id ;" + "DELETE FROM articles WHERE user_id = :id ;" + "DELETE FROM news WHERE user_id = :id ;" + "DELETE FROM itis_user WHERE id = :id ;", nativeQuery = true)
    void deleteById(Long id);
}

