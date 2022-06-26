package com.tubz.blog.blogapp.services;

import com.tubz.blog.blogapp.dtos.PostDto;
import com.tubz.blog.blogapp.exceptions.ResourceNotFound;
import com.tubz.blog.blogapp.model.Post;
import com.tubz.blog.blogapp.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto savePost(PostDto postDto) {
        Post savedPost = postRepository.save(mapToEntity(postDto));
        return mapToDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPost() {
        return postRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPost(Long id) {
        Post referenceById = postRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Posts", "id", id));
        return mapToDto(referenceById);
    }


    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        return post;
    }
}
