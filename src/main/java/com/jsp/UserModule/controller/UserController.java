package com.jsp.UserModule.controller;

import com.jsp.UserModule.dto.UserRequest;
import com.jsp.UserModule.dto.UserResponse;
import com.jsp.UserModule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qeats/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.register(userRequest));
    }
}
















