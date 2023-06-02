package com.post.posthub.controller;

import com.post.posthub.Entity.User;
import com.post.posthub.Service.UserService;
import com.post.posthub.exception.InvalidCredentialsException;
import com.post.posthub.exception.UserAlreadyExistsException;
import com.post.posthub.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User signUpRequest, Model model) {
        try {
            User user = userService.signUp(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword());
            model.addAttribute("user", user);
            return "redirect:/posts/all";
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User loginRequest, Model model) {
        try {
            User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
            model.addAttribute("user", user);
            return "redirect:/posts/all";
        } catch (InvalidCredentialsException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";
        } catch (UserNotFoundException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login";        }
    }
}
