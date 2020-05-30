package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.UsersSearchResult;

public interface SearchService {
    UsersSearchResult searchUsers(String query,Integer page, Integer size);
}
