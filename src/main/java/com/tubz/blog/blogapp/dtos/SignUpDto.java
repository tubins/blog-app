package com.tubz.blog.blogapp.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Post model information")
@Data
public class SignUpDto {
    @ApiModelProperty(value = "Blog signup name")
    private String name;
    @ApiModelProperty(value = "Blog signup userName")
    private String userName;
    @ApiModelProperty(value = "Blog signup email")
    private String email;
    @ApiModelProperty(value = "Blog signup password")
    private String password;
}
