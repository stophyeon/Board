package com.example.board.service;

import com.example.board.aop.TimeCheck;
import com.example.board.domain.User;
import com.example.board.domain.UserSec;
import com.example.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsersDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UsersDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @TimeCheck
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("userdetailservice 호출");
        User user = userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("가입되어있지 않습니다."));
        return UserSec.builder()
                .user(user)
                .build();

    }
}
