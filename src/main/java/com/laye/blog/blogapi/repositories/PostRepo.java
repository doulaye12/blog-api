package com.laye.blog.blogapi.repositories;

import com.laye.blog.blogapi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<PostRepo> findByAuthorId(Long authorId);
}
