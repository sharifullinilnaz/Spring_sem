package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.EditProfileService;

@Controller
public class EditProfileController {

    @Autowired
    private EditProfileService service;

    @GetMapping("/editProfile")
    public String getEditProfilePage(){
        return "edit_profile";
    }

    @PostMapping(path = "/editProfile")
    public String editProfile(@RequestParam("name") String name,
                              @RequestParam("surname") String surname,
                              @RequestParam("city") String city,
                              @RequestParam("email") String email,
                              @RequestParam("nickname") String nickname,
                              Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        service.editProfile(name,surname,city,email,nickname, userDetails.getUser());
        return "redirect:/";
    }

}
