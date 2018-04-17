package com.springsecurity.example.securityexample.dto;

import lombok.Data;

import java.util.List;

@Data
public class StaffResponse {

    private String responseMessage;
    private String responseCode;
    private List<Staff> staff;
}
