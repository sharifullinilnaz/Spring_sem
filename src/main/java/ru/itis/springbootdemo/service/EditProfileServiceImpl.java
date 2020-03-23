package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

@Component
public class EditProfileServiceImpl implements EditProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void editProfile(String name, String surname, String city, String email, String nickname, User user) {
        user.setCity(city);
        user.setName(name);
        user.setEmail(email);
        user.setNickname(nickname);
        user.setSurname(surname);

        usersRepository.save(user);
    }
}
