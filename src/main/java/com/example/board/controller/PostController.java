package com.example.board.controller;

import com.example.board.dto.PostDto;
import com.example.board.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/new")
    public String write(){return "board";}
    @PostMapping("/new")
    public String writePost(@Valid PostDto postDto){
       // postService.newPost(postDto);
        return "home";
    }
}
