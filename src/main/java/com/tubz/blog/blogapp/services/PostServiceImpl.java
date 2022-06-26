package com.tubz.blog.blogapp.services;

import com.tubz.blog.blogapp.dtos.PostDto;
import com.tubz.blog.blogapp.exceptions.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Posts", "id", id));
        return mapToDto(referenceById);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
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
