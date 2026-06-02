package com.jsp.service;

import com.jsp.dto.LoginRequest;
import com.jsp.dto.UserRequest;
import com.jsp.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse register(UserRequest user);
    UserResponse login(LoginRequest login);
    UserResponse profile(String id);
}