package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.SignUpDto;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ExecutorService executorService;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .name(form.getName())
                .createdAt(LocalDateTime.now())
                .state(State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        usersRepository.save(user);

        executorService.submit(() ->
                emailService.sendMail("Confirm", user, user.getEmail()));
    }
}


