package com.example.board.repository;

import com.example.board.domain.User;
import com.example.board.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    List<User> findFirst3ByUserName(String name);
    Optional<User> findByEmailAndPassword(String email,String password);


}
