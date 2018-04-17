package com.springsecurity.example.securityexample.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String roles;

    public Staff(){
    }
    public Staff(Staff staff) {
        this.name = staff.getName();
        this.email = staff.getEmail();
        this.phone = staff.getPhone();
        this.address = staff.getAddress();
        this.password = staff.getPassword();
        this.roles = staff.getRoles();
    }
}
