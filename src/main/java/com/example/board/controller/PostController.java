package com.example.board.controller;

import com.example.board.dto.PostDto;
import com.example.board.service.PostService;
import com.example.board.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/post")
public class PostController {
    private final PostService postService;
    private final UserService userService;
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/new")
    public String write(){return "board";}
    @PostMapping("/new")
    public String writePost(@Valid PostDto postDto){
        postService.newPost(postDto);
        return "home";
    }
//    @PostMapping("/search")
//    public String showPosts(String name, Model model){
//        model.addAllAttributes(userService.getPost(name));
//        return "posts";
//    }
}
