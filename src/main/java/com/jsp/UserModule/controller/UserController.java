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
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.register(userRequest));
    }
















//
////     Constructor Injection
//    public UserController(UserService userService){
//        this.userService=userService;
//    }
//
////    GET ALL USERS (Admin purpose)
//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }
//
////    get user by  id
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Integer id){
//        return userService.getUserById(id).orElseThrow(()->new RuntimeException("User not found with id : " + id));
//
//    }
//
////    update user
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Integer id, @RequestBody User user ){
//        return userService.updateUser(id,user);
//    }
//
////    delete user
//    @DeleteMapping("/{id}")
//
//    public String deleteUserById(@RequestParam Integer id){
//        userService.deleteUser(id);
//        return "User delete succesfully";
//    }
//
////    register
//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user){
//        return userService.register(user);
//    }
//
////    login
//    @PostMapping("/login")
//    public User loginUser(@RequestBody User user){
//        return userService.login(user.getEmail(),user.getPassword());
//    }


}