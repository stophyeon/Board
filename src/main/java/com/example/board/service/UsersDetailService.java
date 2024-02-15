package com.example.board.service;

import com.example.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Slf4j
public class UsersDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public UsersDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            return userRepository.findByEmail(username).get();
        }catch (NullPointerException e){
            log.info(e.getMessage());
            return null;
        }

    }
}
