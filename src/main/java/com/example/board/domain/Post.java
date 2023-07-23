package com.example.board.domain;

import com.example.board.dto.PostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_Id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Post(String title,String content){
        this.title=title;
        this.content=content;}

    public Post(PostDto postDto, User user) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.user = user;
    }
}
