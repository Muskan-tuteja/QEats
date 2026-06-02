package com.jsp.UserModule.service;
import com.jsp.UserModule.model.User;

import com.jsp.UserModule.dto.LoginRequest;
import com.jsp.UserModule.dto.UserRequest;
import com.jsp.UserModule.dto.UserResponse;

import com.jsp.UserModule.dao.UserRepository;


public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse register(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new RuntimeException("Email id already exists");
        }
        User user = new User(userRequest);
        user.setRole("CUSTOMER");
        user.setActive(true);
//        SAVE TO DATABASE
        User savedUser=userRepository.save(user);

        return new UserResponse(savedUser);

    }

    @Override
    public UserResponse login(LoginRequest login){
        return null;
    }

    @Override
    public UserResponse profile(String id){
        return null;
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