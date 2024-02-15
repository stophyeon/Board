package com.example.board.repository;

import com.example.board.domain.Post;
import com.example.board.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    void findFirstByUserid() {
        User user = new User("정지현","1234","jj1234@naver.com");
        Post post=postRepository.findFirstByUser(user).get();
        System.out.println(post.getTitle());
    }
}