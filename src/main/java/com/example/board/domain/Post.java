package com.example.board.domain;

import com.example.board.dto.PostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_Id;
    private String title;
    private String content;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private User user;

    public Post(String title,String content){
        this.title=title;
        this.content=content;}

    public Post(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        //this.user = user;
    }
}
