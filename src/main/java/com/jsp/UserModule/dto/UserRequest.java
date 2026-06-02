package com.jsp.UserModule.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private Long phone;
    private String password;

}