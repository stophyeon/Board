package com.example.board.service;

import com.example.board.annotation.TimeCheck;
import com.example.board.domain.User;
import com.example.board.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    @TimeCheck
    void newUser() {
        UserDto userDto = new UserDto("jjh","12345678","jj6778@naver.com");
        userService.newUser(userDto);
    }
}