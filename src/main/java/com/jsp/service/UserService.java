package com.jsp.service;

import com.jsp.entity.User;
import com.jsp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User updateUser(Integer id,User updateUser){
        return userRepository.findById(id).map(user->{
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            user.setRole(updateUser.getRole());
            return userRepository.save(user);
        }).orElseThrow(()->new RuntimeException("User not found"));
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    //    to register
    public User register(User user){
        user.setRole("CUSTOMER");
        return userRepository.save(user);
    }

    //    to login
    public User login(String email , String password){
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Invalid email"));
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

}
