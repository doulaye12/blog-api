package com.laye.blog.blogapi.repositories;

import com.laye.blog.blogapi.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<CommentRepo> findByPostId(Long postId);
}
