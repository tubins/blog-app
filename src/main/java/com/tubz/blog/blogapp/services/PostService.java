package com.tubz.blog.blogapp.services;

import com.tubz.blog.blogapp.dtos.PostDto;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);
    List<PostDto> getAllPost();
    PostDto getPost(Long id);
}
