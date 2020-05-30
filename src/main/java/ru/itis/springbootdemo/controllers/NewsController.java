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
import ru.itis.springbootdemo.dto.NewsDto;
import ru.itis.springbootdemo.models.Article;
import ru.itis.springbootdemo.models.News;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ArticleService;
import ru.itis.springbootdemo.service.FileStorageService;
import ru.itis.springbootdemo.service.NewsService;

import java.util.List;

@Controller
public class NewsController {
    @Autowired
    private NewsService service;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/addNews")
    public String getAddNewsPage(Authentication authentication,Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "add_news";
    }

    @PostMapping("/addNews")
    public String addNews(NewsDto form, Authentication authentication, @RequestParam("file") MultipartFile file) {
        String photoPath = "http://localhost/files/" + fileStorageService.saveFile(file);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        service.add(form,userDetails.getUser(), photoPath);
        return "redirect:/profile/" + userDetails.getUser().getId();
    }

    @GetMapping("/news")
    public String getNews(Authentication authentication,Model model) {
        List<News> news = service.getNews();
        model.addAttribute("news", news);
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userDetails.getUser();
            model.addAttribute("user", user);
        }
        return "news";
    }

}