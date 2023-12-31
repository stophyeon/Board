package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.Post;
import com.example.board.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        System.out.println(userService.joinUser(userDto.getEmail(),"12345678"));

    }
    @Test
    @TimeCheck
    void post(){
        List<Post> posts=userService.getPost("jjh");
        posts.forEach(post -> {System.out.println(post.getTitle());});

    }
}