package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.News;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsDto {
    private Long id;
    private String title;
    private String photoPath;
    private LocalDateTime date;
    private String text;

    public static NewsDto from(News news) {
        return NewsDto.builder()
                .id(news.getId())
                .title(news.getTitle())
                .photoPath(news.getPhotoPath())
                .date(news.getDate())
                .text(news.getText())
                .build();
    }

    public static List<NewsDto> from(List<News> news) {
        return news.stream()
                .map(NewsDto::from)
                .collect(Collectors.toList());
    }
}