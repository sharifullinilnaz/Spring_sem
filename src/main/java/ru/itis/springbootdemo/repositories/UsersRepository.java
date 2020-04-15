package ru.itis.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmCode(String confirmCode);
    List<User> findAllByNameContainsIgnoreCase(String name);

    @Query("from User user where " +
            "upper(user.email) like concat('%', upper(:query), '%') or " +
            "upper(user.name) like concat('%', upper(:query), '%')")
    Page<User> search(@Param("query") String query,Pageable pageable);

}

