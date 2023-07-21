package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.User;
import com.example.board.dto.UserDto;
import com.example.board.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @TimeCheck
    public void newUser(UserDto userDto){
        User user = new User(userDto);
        if (userRepository.findByEmail(user.getEmail()).equals(user)){
            return;
        }
        else{
            userRepository.save(user);
        }
    }
}
