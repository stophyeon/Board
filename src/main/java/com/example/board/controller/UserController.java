package com.example.board.controller;

import com.example.board.dto.UserDto;
import com.example.board.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/user")
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
        return"index";
    }
    @PostMapping("")
    public String login(UserDto userDto){
        if (userService.joinUser(userDto.getEmail(),userDto.getPassword())==true)
        {return "home";}
        else{return"redirect:/";}
    }
}
