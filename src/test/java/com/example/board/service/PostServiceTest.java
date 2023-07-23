package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.dto.PostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Test
    void newPost() {
        User user = userService.findOne("jj1234@naver.com").orElseThrow();
        PostDto postDto = new PostDto("정재학입니다.","안녕하세요");
        postService.newPost(postDto,user);
    }
    @Test
    void getPost(){
        User user = userService.findOne("jj1234@naver.com").orElseThrow();
        PostDto postDto = new PostDto("정지현입니다.","안녕하세요");
        Post post = new Post(postDto,user);
        postService.getPostByTitle("정재학입니다.").ifPresent(p->{System.out.println(p.getContent());});
        postService.newPost(postDto,user);
    }
}