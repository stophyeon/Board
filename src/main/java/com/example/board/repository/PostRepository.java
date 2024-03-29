package com.example.board.repository;

import com.example.board.domain.Post;
import com.example.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Optional<Post> findByTitle(String title);
    Optional<List<Post>> findByUser(User user);
}
