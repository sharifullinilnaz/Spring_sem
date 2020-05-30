package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.springbootdemo.dto.UsersSearchResult;
import ru.itis.springbootdemo.service.SearchService;


@RestController
@RequestMapping("/authors")
public class SearchController {

    @Autowired
    private SearchService service;

    @GetMapping("/search")
    public UsersSearchResult searchExercises(
            @RequestParam("query") String query,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        return service.searchUsers(query, page, size);
    }
}
