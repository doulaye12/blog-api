package com.laye.blog.blogapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Comment extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
