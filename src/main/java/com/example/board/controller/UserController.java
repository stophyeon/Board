package com.example.board.controller;

import com.example.board.dto.UserDto;
import com.example.board.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/user")
@Slf4j
public class UserController {
    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/new")
    public String signup(){return "signup";}
    @PostMapping("/new")
    public String signup(@Valid UserDto userDto){
        userService.newUser(userDto);
        return "index";
    }
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("posts",userService.myPost());

        return "home";
    }

}
