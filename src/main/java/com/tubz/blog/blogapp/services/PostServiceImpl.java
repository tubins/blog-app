package com.tubz.blog.blogapp.services;

import com.tubz.blog.blogapp.dtos.PostDto;
import com.tubz.blog.blogapp.model.Post;
import com.tubz.blog.blogapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto savePost(PostDto postDto) {
        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        Post savedPost = postRepository.save(post);
        PostDto toReturn = new PostDto();
        toReturn.setId(savedPost.getId());
        toReturn.setContent(savedPost.getContent());
        toReturn.setTitle(savedPost.getTitle());
        toReturn.setDescription(savedPost.getDescription());
        return toReturn;
    }
}
