package com.springsecurity.example.securityexample.controller;

import com.springsecurity.example.securityexample.dao.Login;
import com.springsecurity.example.securityexample.dao.Staff;
import com.springsecurity.example.securityexample.dto.StaffResponse;
import com.springsecurity.example.securityexample.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String normal(){
        return "normal test worked";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value = "/secured/user/test", method = RequestMethod.GET)
    public String securedUser(){
        return "secured user test worked";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/secured/admin/test", method = RequestMethod.GET)
    public String securedAdmin(){
        return "secured admin test worked";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(@RequestBody Login login){

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public StaffResponse add(@RequestBody Staff staff){

        return staffService.add(staff);
    }

    @RequestMapping(value = "delete{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam("id") Long id){

    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public void update(@RequestParam("id") Long id, @RequestBody Staff staff){

    }

    @RequestMapping(value = "view{id}", method = RequestMethod.GET)
    public void viewStaff(@RequestParam("id") Long id){

    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public void viewAllStaff(){

    }
}
