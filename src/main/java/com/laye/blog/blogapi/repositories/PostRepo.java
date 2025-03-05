package com.laye.blog.blogapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Post extends JpaRepository<Post, Integer> {
    List<Post> findByAuthorId(Long authorId);
}
