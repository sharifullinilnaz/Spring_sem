package ru.itis.springbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.ArticleDto;
import ru.itis.springbootdemo.dto.CommentDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.Comment;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ArticleService;
import ru.itis.springbootdemo.service.CommentService;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;


    @GetMapping("/article/{article_id}")
    public String getConcreteArticlePage(@PathVariable("article_id") Long articleId,
                                          Model model,
                                          Authentication authentication) {
        User user = null;
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            user = userDetails.getUser();
        }
        Article article = articleService.getConcreteArticle(articleId);
        List<Comment> comments= commentService.getAllCommentsToArticle(articleId);
        model.addAttribute("article", article);
        model.addAttribute("user", user);
        model.addAttribute("comments", comments);

        return "article";
    }

    @PostMapping("/article/{article_id}")
    public String addComment(CommentDto form, Authentication authentication,@PathVariable("article_id") Long articleId) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Article article = articleService.getConcreteArticle(articleId);
        commentService.add(form,userDetails.getUser(),article);
        return "redirect:/article/" + article.getId();
    }


}
