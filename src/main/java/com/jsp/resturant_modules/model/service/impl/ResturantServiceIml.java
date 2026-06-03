package com.jsp.resturant_modules.model.service.impl;

import com.jsp.UserModule.dao.UserRepository;
import com.jsp.UserModule.model.User;
import com.jsp.exception.UserException;
import com.jsp.resturant_modules.model.dto.ResturantRequest;
import com.jsp.resturant_modules.model.model.Resturant;
import com.jsp.resturant_modules.model.service.ResturantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResturantServiceIml implements ResturantService {
    private final UserRepository userRepository;
    private final ResturantService resturantService;

    @Override
    public Resturant createResturant(ResturantRequest resturantRequest) {
        Integer managerId = resturantRequest.getUser_id();
        User user = userRepository.findById(managerId).orElseThrow(()-> new UserException("User not Found"));
}
