package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.CookieValue;
import ru.itis.springbootdemo.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CookieValueDto {
    private String value;
    private User user;

    public static CookieValueDto from(CookieValue cookieValue) {
        return CookieValueDto.builder()
                .value(cookieValue.getValue())
                .user(cookieValue.getUser())
                .build();
    }

    public static List<CookieValueDto> from(List<CookieValue> cookieValues) {
        return cookieValues.stream()
                .map(CookieValueDto::from)
                .collect(Collectors.toList());
    }
}
