package com.tubz.blog.blogapp.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Post model information")
@Data
public class PostDto {
    @ApiModelProperty(value = "Blog post id")
    public Long id;
    @ApiModelProperty(value = "Blog post title")
    @NotEmpty
    @Size(min = 2, message = "Post title should have minimum 2 characters.")
    public String title;
    @ApiModelProperty(value = "Blog post description")
    @NotEmpty
    @Size(min = 10, message = "Post description should have minimum 10 characters.")
    public String description;
    @ApiModelProperty(value = "Blog post content")
    @NotEmpty
    public String content;
}
