package com.jsp.dto;


import lombok.Data;

@Data
public class UserResponse {
    private String name;
    private String email;
    private Long phone;
}