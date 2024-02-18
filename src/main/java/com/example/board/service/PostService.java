package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.domain.UserSec;
import com.example.board.dto.PostDto;
import com.example.board.repository.PostRepository;
import com.example.board.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public void newPost(PostDto postDto){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserSec user = (UserSec)auth.getPrincipal();
        User user1=userRepository.findByEmail(user.getUsername()).get();
        Post post=new Post(postDto,user1);
        postRepository.save(post);
    }
    public Optional<Post> getPostByTitle(String title){
        return postRepository.findByTitle(title);
    }
    @TimeCheck
    public void erasePost(Long id){
        log.info("삭제 메서드 호출");
        postRepository.deleteById(id);
    }
}
