package ru.itis.springbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.springbootdemo.security.UserDetailsImpl;

@RequestMapping("/")
@Controller
public class RootController {
    @GetMapping
    public String getRootPage(Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return "redirect:/profile/" + userDetails.getUser().getId();
        } else {
            return "redirect:/signIn";
        }
    }
}
