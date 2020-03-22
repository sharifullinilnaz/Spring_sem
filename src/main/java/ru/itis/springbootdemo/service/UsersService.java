package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    boolean existCookie(String cookie);

    UserDto getConcreteUser(Long userId);

    List<UserDto> search(String name);

}
