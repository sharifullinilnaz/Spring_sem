package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.models.CookieValue;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.CookieValuesRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.util.UUID;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Override
    public String signIn(String email, String password) {
        User user = usersRepository.findByEmail(email);

        String value = null;
        if (user != null && user.getPassword().equals(password)) {
            value = UUID.randomUUID().toString();
            CookieValue cookieValue = CookieValue.builder()
                    .value(value)
                    .user(user)
                    .build();
            cookieValuesRepository.save(cookieValue);
        }
        return value;
    }
}
