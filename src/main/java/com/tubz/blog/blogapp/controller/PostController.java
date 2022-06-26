package com.tubz.blog.blogapp.controller;

import com.tubz.blog.blogapp.dtos.PostDto;
import com.tubz.blog.blogapp.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        PostDto savedPost = postService.savePost(postDto);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
}
