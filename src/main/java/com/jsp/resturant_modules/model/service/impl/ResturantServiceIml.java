package com.jsp.resturant_modules.model.service.impl;

import com.jsp.UserModule.dao.UserRepository;
import com.jsp.UserModule.model.User;
import com.jsp.exception.UserException;
import com.jsp.resturant_modules.model.dto.ResturantRequest;
import com.jsp.resturant_modules.model.dto.ResturantResponse;
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
    public Resturant createResturant(ResturantRequest resturantRequest) throws UserException {
        Integer managerId = resturantRequest.getUser_id();
        User user = userRepository.findById(managerId)
                .orElseThrow(()-> new UserException("User not Found"));

        Resturant resturant = new Resturant();
        resturant.setResturantName(resturantRequest.getResturantName());
        resturant.setPhone(resturantRequest.getPhone());
        resturant.setAddress(resturantRequest.getAddress());
        resturant.setPincode(resturantRequest.getPincode());
        resturant.setImage(resturantRequest.getImage());
        resturant.setManager(user);
        return resturant;
    }
}


