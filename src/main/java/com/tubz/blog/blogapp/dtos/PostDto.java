package com.tubz.blog.blogapp.dtos;

import lombok.Data;

@Data
public class PostDto {
    public Long id;
    public String title;
    public String description;
    public String content;
}
