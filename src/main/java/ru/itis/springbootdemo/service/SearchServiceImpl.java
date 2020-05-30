package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.dto.UsersSearchResult;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UsersSearchResult searchUsers(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> pageResult = usersRepository.search(query, pageRequest);
        List<UserDto> users = UserDto.from(pageResult.getContent());
        return UsersSearchResult.builder()
                .users(users)
                .count(pageResult.getTotalPages())
                .build();
    }
}

