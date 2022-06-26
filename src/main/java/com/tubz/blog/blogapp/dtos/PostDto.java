package com.tubz.blog.blogapp.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PostDto {
    public Long id;
    @NotEmpty
    @Size(min = 2, message = "Post title should have minimum 2 characters.")
    public String title;
    @NotEmpty
    @Size(min = 10, message = "Post description should have minimum 10 characters.")
    public String description;
    @NotEmpty
    public String content;
}
