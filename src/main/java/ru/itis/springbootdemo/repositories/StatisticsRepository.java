package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Statistic;

public interface StatisticsRepository extends JpaRepository<Statistic, Long> {

}
