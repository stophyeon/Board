package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.Post;
import com.example.board.domain.User;
import com.example.board.dto.UserDto;
import com.example.board.repository.PostRepository;
import com.example.board.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (userRepository.findByEmail(user.getEmail()).equals(user)) {
            return;
        } else {
            userRepository.save(user);
        }
    }
    //Test용
    public Optional<User> findOne(String email){
        Optional<User> user =userRepository.findByEmail(email);
        return user;
    }
    @TimeCheck
    public boolean joinUser(String email,String password) {
        return userRepository.findByEmailAndPassword(email,password).isPresent();
    }
    public List<Post> getMyPost(UserDto userDto){
        User user = new User(userDto);
        List<Post> myPost = new ArrayList<>();
        myPost=postRepository.findByUser(user);
        return myPost;
    }

}