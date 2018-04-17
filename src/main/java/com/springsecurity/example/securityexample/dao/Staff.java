package com.springsecurity.example.securityexample.dao;

import lombok.Data;

import java.util.List;

@Data
public class Staff {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String roles;

}
