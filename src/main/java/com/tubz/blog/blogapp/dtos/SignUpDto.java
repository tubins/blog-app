package com.tubz.blog.blogapp.dtos;

import lombok.Data;

@Data
public class SignUpDto {
    private String name;
    private String userName;
    private String email;
    private String password;
}
