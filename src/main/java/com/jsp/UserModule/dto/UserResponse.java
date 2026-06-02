package com.jsp.UserModule.dto;


import com.jsp.UserModule.model.User;
import lombok.Data;

@Data
public class UserResponse {
    private String name;
    private String email;
    private Long phone;


    public UserResponse(User user) {
        this.name=user.getName();
        this.email=user.getEmail();
        this.phone=user.getPhone();
    }
}