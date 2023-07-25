package com.example.board.domain;

import com.example.board.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    List<Post> myBoards;

    public User(UserDto userDto){
        this.userName=userDto.getUserName();
        this.email=userDto.getEmail();
        this.password=userDto.getPassword();
    }
}
