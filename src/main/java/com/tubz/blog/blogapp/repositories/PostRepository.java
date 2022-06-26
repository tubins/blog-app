package com.tubz.blog.blogapp.repositories;

import com.tubz.blog.blogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
