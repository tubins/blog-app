package com.tubz.blog.blogapp.controller;

import com.tubz.blog.blogapp.dtos.PostDto;
import com.tubz.blog.blogapp.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<PostDto> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

}