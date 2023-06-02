package com.post.posthub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }


}