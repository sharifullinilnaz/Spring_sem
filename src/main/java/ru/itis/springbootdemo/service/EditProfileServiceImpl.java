package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

@Component
public class EditProfileServiceImpl implements EditProfileService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void editProfile(UserDto changedUser, User user) {
        user.setName(changedUser.getName());
        user.setSurname(changedUser.getSurname());
        user.setCity(changedUser.getCity());
        user.setEmail(changedUser.getEmail());
        user.setNickname(changedUser.getNickname());
        usersRepository.save(user);
    }
}
