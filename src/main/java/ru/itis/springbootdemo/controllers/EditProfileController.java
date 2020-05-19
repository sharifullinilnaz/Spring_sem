package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.EditProfileService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.ProfileForm;
import javax.validation.Valid;

@Controller
public class EditProfileController {

    @Autowired
    private EditProfileService service;

    @GetMapping("/editProfile")
    public String getEditProfilePage(Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("profileForm", new ProfileForm());
        return "edit_profile";
    }

    @PostMapping(path = "/editProfile")
    public String editProfile(Authentication authentication, @Valid ProfileForm form, BindingResult bindingResult, Model model) {
        System.out.println(form);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        System.out.println(bindingResult.getAllErrors());
        model.addAttribute("profileForm", form);
        if (!bindingResult.hasErrors()) {
            UserDto changedUser = UserDto.builder()
                    .id(userDetails.getUser().getId())
                    .name(form.getName())
                    .year(userDetails.getUser().getYear())
                    .city(form.getCity())
                    .nickname(form.getNickname())
                    .surname(form.getSurname())
                    .email(form.getEmail())
                    .role(userDetails.getUser().getRole().name())
                    .state(userDetails.getUser().getState().name())
                    .build();
            service.editProfile(changedUser, userDetails.getUser());
            return "redirect:/";
        }else {
            return "edit_profile";
        }
    }

}
