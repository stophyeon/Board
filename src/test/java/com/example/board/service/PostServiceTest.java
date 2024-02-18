package com.example.board.service;

import com.example.board.domain.User;
import com.example.board.domain.UserSec;
import com.example.board.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;
    @Test
    void newPost() {
        PostDto postDto = new PostDto("test","테스트");
        com.example.board.domain.User user1 = User.builder()
                .email("test@naver.com")
                .password("1234")
                .userName("test")
                .build();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user1,"");

        SecurityContextHolder.getContext().setAuthentication(token);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUserName());
    }
}