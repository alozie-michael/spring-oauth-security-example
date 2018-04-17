package com.springsecurity.example.securityexample.service;

import com.springsecurity.example.securityexample.dao.Login;
import com.springsecurity.example.securityexample.dao.Staff;
import com.springsecurity.example.securityexample.dto.StaffResponse;

public interface StaffService {

    StaffResponse add(Staff staff);
    StaffResponse viewstaff();
    StaffResponse delete(Long id);
    StaffResponse update(Long id, Staff staff);
    StaffResponse login(Login login);

}
