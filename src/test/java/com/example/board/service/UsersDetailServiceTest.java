package com.example.board.service;

import com.example.board.domain.UserSec;
import com.example.board.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UsersDetailServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test

    void loadUserByUsername() {
        UsersDetailService usersDetailService=new UsersDetailService(userRepository);
        UserDetails userDetails =usersDetailService.loadUserByUsername("jj6778@naver.com");
        System.out.println(userDetails.getUsername()+","+userDetails.getPassword());
    }
}