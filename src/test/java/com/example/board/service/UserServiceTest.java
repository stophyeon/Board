package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    @TimeCheck
    void newUser() {
        UserDto userDto = new UserDto("jjh","12345678","jj1234@naver.com");
        userService.newUser(userDto);
    }
    @Test
    @TimeCheck
    void joinUser() {
        UserDto userDto = new UserDto("jjh","12345678","jj1234@naver.com");
        userService.findOne("jj1234@naver.com");
        System.out.println(userService.joinUser(userDto.getEmail(),"123456789"));

    }
}