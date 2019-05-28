package com.springsecurity.example.securityexample.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {

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

}
