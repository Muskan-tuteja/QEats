package com.jsp.resturant_modules.model.service;

import com.jsp.resturant_modules.model.model.Resturant;
import com.jsp.resturant_modules.model.dto.ResturantRequest;
import org.springframework.stereotype.Service;

@Service
public interface ResturantService {

    Resturant createResturant(ResturantRequest resturantRequest);

}
