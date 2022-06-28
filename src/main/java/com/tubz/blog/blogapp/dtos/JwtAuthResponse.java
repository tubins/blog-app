package com.tubz.blog.blogapp.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
