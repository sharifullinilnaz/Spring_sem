package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.dto.ArticleDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ArticleService;
import ru.itis.springbootdemo.service.FileStorageService;

import java.util.List;
import java.util.Optional;

@Controller
public class AddArticleController {
    @Autowired
    private ArticleService service;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/addArticle")
    public String getAddArticlePage(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "add_article";
    }

    @PostMapping("/addArticle")
    public String addArticle(ArticleDto form, Authentication authentication, @RequestParam("file") MultipartFile file) {
        String photoPath = "http://localhost/files/" + fileStorageService.saveFile(file);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        service.add(form,userDetails.getUser(), photoPath);
        return "redirect:/profile/" + userDetails.getUser().getId();
    }

    @GetMapping("/articles")
    public String getArticles(Authentication authentication,Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userDetails.getUser();
            model.addAttribute("user", user);
        }
        List<Article> articles = service.getArticles();
        model.addAttribute("articles", articles);
        return "articles_page";
    }

    @GetMapping("/articles/{author_id}")
    public String getConcreteArticlePage(@PathVariable("author_id") Long authorId,
                                         Model model,
                                         Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userDetails.getUser();
            model.addAttribute("user", user);
        }
        List<Article> articles = service.getAllAuthorArticles(authorId);
        model.addAttribute("articles", articles);

        return "authors_articles";
    }
}