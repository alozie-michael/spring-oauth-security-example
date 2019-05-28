package com.springsecurity.example.securityexample.model;

import lombok.Data;

@Data
public class Staff {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String roles;

}
