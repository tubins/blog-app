package com.tubz.blog.blogapp.services;

import com.tubz.blog.blogapp.dtos.PostDto;
import com.tubz.blog.blogapp.dtos.PostResponse;

import java.util.List;

public interface PostService {
    PostDto savePost(PostDto postDto);
     PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPost(Long id);
    PostDto updatePost(PostDto postDto, Long id);
    void deletePostById(Long id);
}
