package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.CookieValuesRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;
import static ru.itis.springbootdemo.dto.UserDto.from;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Override
    public List<UserDto> getUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public boolean existCookie(String cookie){
        ru.itis.springbootdemo.models.CookieValue cookieValueDb = cookieValuesRepository.findByValue(cookie);
        return cookieValueDb != null;
    }

    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByNameContainsIgnoreCase(name));
    }

}
