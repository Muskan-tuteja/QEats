package com.jsp.controller;

import com.jsp.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserServiceIml userService;

    //     Constructor Injection
    public UserController(UserServiceIml userService){
        this.userService=userService;
    }

    //    GET ALL USERS (Admin purpose)
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //    get user by  id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id).orElseThrow(()->new RuntimeException("User not found with id : " + id));

    }

    //    update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user ){
        return userService.updateUser(id,user);
    }

    //    delete user
    @DeleteMapping("/{id}")

    public String deleteUserById(@RequestParam Integer id){
        userService.deleteUser(id);
        return "User delete succesfully";
    }

    //    register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.register(user);
    }

    //    login
    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        return userService.login(user.getEmail(),user.getPassword());
    }


}
