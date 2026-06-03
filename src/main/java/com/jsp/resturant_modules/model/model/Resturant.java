package com.jsp.resturant_modules.model.model;

import com.jsp.UserModule.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Resturant {
    @Id
    private Long resturantId;
    private String resturantName;
    private Long phone;
    private String address;
    private String image;
    private Integer pincode;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private User manager;


}
