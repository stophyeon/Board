package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.dto.UserDto;
import com.example.board.repository.PostRepository;
import com.example.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PostRepository postRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @TimeCheck
    public void newUser(UserDto userDto) {
        User user = User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
        if (!Duplicate(userDto)){userRepository.save(user);}
        else{log.info("이미가입된어있습니다");}

    }
    public boolean Duplicate(UserDto userDto){
        Optional<User> user = userRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
        return user.isPresent();
    }


    @TimeCheck
    public boolean joinUser(String email,String password) {
        return userRepository.findByEmailAndPassword(email,password).isPresent();
    }
//    @TimeCheck
//    @Transactional
//    public List<Post> getPost(String name){
//        List<Post> posts = new ArrayList<>();
//        List<User> user = userRepository.findFirst3ByUserName(name);
//        user.forEach(u->{
//                    posts.addAll(u.getMyBoards());
//                }
//        );
//        return posts;
//    }

}