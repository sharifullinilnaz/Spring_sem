package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.UsersService;

@Controller
public class ProfileController {

    @Autowired
    private UsersService userService;

    @GetMapping("/profile/{user_id}")
    public String getProfile(@PathVariable("user_id") Long userId, Authentication authentication, Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userDetails.getUser();
            model.addAttribute("user", user);
        }
        UserDto profileUser = userService.getConcreteUser(userId);
        model.addAttribute("profile_user", profileUser);
        return "profile";
    }
}