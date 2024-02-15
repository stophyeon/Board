package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.dto.PostDto;
import com.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void newPost(PostDto postDto){
        Post post=new Post(postDto);
        postRepository.save(post);
    }
    public Optional<Post> getPostByTitle(String title){
        return postRepository.findByTitle(title);
    }

}
