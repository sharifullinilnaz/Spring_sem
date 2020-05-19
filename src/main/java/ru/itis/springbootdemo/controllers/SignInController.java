package ru.itis.springbootdemo.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignIn(Authentication authentication) {
        if(authentication != null) {
            return "redirect:/";
        } else {
            return "sign_in";
        }
    }
}
