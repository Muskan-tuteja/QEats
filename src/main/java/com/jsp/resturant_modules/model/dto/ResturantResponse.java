package com.jsp.resturant_modules.model.dto;

import lombok.Data;

@Data
public class ResturantResponse {
    private Long id;
    private String resturantName;
    private Long phone;
    private String address;
    private Integer pincode;
    private String image;
    private Integer user_id;
}
