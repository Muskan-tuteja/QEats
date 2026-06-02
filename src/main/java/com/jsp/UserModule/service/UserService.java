package com.jsp.UserModule.service;

import com.jsp.UserModule.dto.LoginRequest;
import com.jsp.UserModule.dto.UserRequest;
import com.jsp.UserModule.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
//    userResponse
    UserResponse register(UserRequest user);
    UserResponse login(LoginRequest login);
    UserResponse profile(String id);
}