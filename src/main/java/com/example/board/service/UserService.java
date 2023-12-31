package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.dto.UserDto;
import com.example.board.repository.PostRepository;
import com.example.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
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
    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @TimeCheck
    public void newUser(UserDto userDto) {
        User user = new User(userDto);
        if (Duplicate(userDto)==false){userRepository.save(user);}
        else{log.info("이미가입된어있습니다");}

    }
    public boolean Duplicate(UserDto userDto){
        Optional<User> user = userRepository.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
        if (user.isEmpty()){return false;}
        else {return true;}
    }

    public Optional<User> findOne(String email){
        Optional<User> user =userRepository.findByEmail(email);
        return user;
    }
    @TimeCheck
    public boolean joinUser(String email,String password) {
        return userRepository.findByEmailAndPassword(email,password).isPresent();
    }
    @TimeCheck
    @Transactional
    public List<Post> getPost(String name){
        List<Post> posts = new ArrayList<>();
        List<User> user = userRepository.findFirst3ByUserName(name);
        user.forEach(u->{
            u.getMyBoards().forEach(p->{
                posts.add(p);}
            );}
        );
        return posts;
    }

}