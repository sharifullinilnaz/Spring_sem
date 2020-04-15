package ru.itis.springbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.ArticleDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ArticleService;
import ru.itis.springbootdemo.service.UsersService;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/{id}")
    public String getConcreteArticlePage(@PathVariable("id") Long articleId,
                                          Model model,
                                          Authentication authentication) {
        User user = null;
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            user = userDetails.getUser();
        }
        Article article = articleService.getConcreteArticle(articleId);
        model.addAttribute("article", article);
        model.addAttribute("user", user);

        return "article";
    }

}
