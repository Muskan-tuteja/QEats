package com.jsp.UserModule.service;
import com.jsp.UserModule.model.Role;
import com.jsp.UserModule.model.User;

import com.jsp.UserModule.dto.LoginRequest;
import com.jsp.UserModule.dto.UserRequest;
import com.jsp.UserModule.dto.UserResponse;

import com.jsp.UserModule.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



//    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserResponse register(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new RuntimeException("Email id already exists");
        }
        User user = new User(userRequest);
        user.setRole(Role.CUSTOMER);
        user.setActive(true);
        User savedUser=userRepository.save(user);

        return new UserResponse(savedUser);

    }

    @Override
    public UserResponse login(LoginRequest login){
        User user = userRepository.findByEmail(login.getEmail()).orElseThrow(()->new RuntimeException("Invalid email"));
        if(user.getPassword().equals(login.getPassword())){
            UserResponse userResponse = new UserResponse(user);
            return userResponse;
        }else {
            throw new RuntimeException("Invalid password");
        }


    }

    @Override
    public UserResponse profile(String id){
        User user = userRepository.findById(Integer.parseInt(id)).orElseThrow(()->new RuntimeException("User not found"));
        return new UserResponse(user);
    }
    @Override
    public UserResponse deleted(String id) {

        User user = userRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);

        return new UserResponse(user);
    }





















