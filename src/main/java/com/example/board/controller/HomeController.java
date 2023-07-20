package com.example.board.controller;

import com.example.board.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

}
