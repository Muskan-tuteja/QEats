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





















//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(Integer id) {
//        return userRepository.findById(id);
//    }

//    public User updateUser(Integer id,User updateUser){
//        return userRepository.findById(id).map(user->{
//            user.setName(updateUser.getName());
//            user.setEmail(updateUser.getEmail());
//            user.setPassword(updateUser.getPassword());
//            user.setRole(updateUser.getRole());
//            return userRepository.save(user);
//        }).orElseThrow(()->new RuntimeException("User not found"));
//    }
//
//    public void deleteUser(Integer id){
//        userRepository.deleteById(id);
//    }
//
////    to register
//    public User register(User user){
//        user.setRole("CUSTOMER");
//        return userRepository.save(user);
//    }
//
////    to login
//    public User login(String email , String password){
//        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Invalid email"));
//        if(!user.getPassword().equals(password)){
//            throw new RuntimeException("Invalid password");
//        }
//        return user;
//    }

}