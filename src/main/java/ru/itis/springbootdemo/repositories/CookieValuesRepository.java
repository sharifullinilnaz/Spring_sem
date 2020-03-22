package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.CookieValue;


public interface CookieValuesRepository extends JpaRepository<CookieValue, Long> {
    CookieValue findByValue(String value);
}
