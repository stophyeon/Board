package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.domain.UserSec;
import com.example.board.dto.UserDto;
import com.example.board.repository.PostRepository;
import com.example.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Transactional
    @TimeCheck
    public Post myPost(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserSec user = (UserSec) authentication.getPrincipal();
        User user1 = userRepository.findByEmail(user.getUsername()).get();
        return postRepository.findFirstByUser(user1).get();
    }

}