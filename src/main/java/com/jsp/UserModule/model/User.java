package com.jsp.UserModule.model;

import com.jsp.UserModule.dto.UserRequest;
import com.jsp.resturant_modules.model.model.Resturant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_table")
@SequenceGenerator(name="user-seq" , allocationSize =1,initialValue=1000)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private Long phone;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    private Boolean active;

    @OneToOne(mappedBy = "manager")
    private Resturant resturant;

    public User(UserRequest userRequest) {
        this.name=userRequest.getName();
        this.email=userRequest.getEmail();
        this.phone=userRequest.getPhone();
        this.password=userRequest.getPassword();
    }

}