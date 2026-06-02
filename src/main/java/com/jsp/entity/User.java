package com.jsp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "user-suq",allocationSize = 1,initialValue=1000)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    @Enumerated(EnumType.STRING)
    private Long phone;



}
