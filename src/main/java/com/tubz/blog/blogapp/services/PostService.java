package com.tubz.blog.blogapp.services;

import com.tubz.blog.blogapp.dtos.PostDto;

public interface PostService {
    PostDto savePost(PostDto postDto);
}
