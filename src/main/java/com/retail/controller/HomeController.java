package com.retail.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@NotNull Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login(@NotNull Model model) {
        return "login";
    }
}
