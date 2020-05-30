package ru.itis.springbootdemo.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "statistic_top_article")
public class StatisticTopArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long articleId;
    private int countOfComments;
    private LocalDateTime date;

}
