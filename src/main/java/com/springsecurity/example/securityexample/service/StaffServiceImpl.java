package com.springsecurity.example.securityexample.service;

import com.springsecurity.example.securityexample.dao.Login;
import com.springsecurity.example.securityexample.dao.Staff;
import com.springsecurity.example.securityexample.dto.StaffResponse;
import com.springsecurity.example.securityexample.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StaffServiceImpl {

//    private final StaffRepository staffRepository;
//
//    @Autowired
//    public StaffServiceImpl(StaffRepository staffRepository) {
//        this.staffRepository = staffRepository;
//    }
//
//
//    @Override
//    public StaffResponse add(Staff staff) {
//
//        StaffResponse staffResponse = new StaffResponse();
//
//        com.springsecurity.example.securityexample.model.Staff existingStaff = staffRepository.findByEmailContaining(staff.getEmail());
//
//        if(existingStaff == null) {
//            com.springsecurity.example.securityexample.model.Staff newStaff = new com.springsecurity.example.securityexample.model.Staff();
//
//            BeanUtils.copyProperties(staff, newStaff);
//            newStaff.setPassword(BCrypt.hashpw(staff.getPassword(), BCrypt.gensalt()));
//            staffRepository.save(newStaff);
//            staffResponse.setResponseCode("00");
//            staffResponse.setResponseMessage("new staff added");
//            return staffResponse;
//        }
//
//        staffResponse.setResponseCode("01");
//        staffResponse.setResponseMessage("staff already exist");
//        return staffResponse;
//    }
//
//    @Override
//    public StaffResponse viewstaff() {
//
//        StaffResponse staffResponse = new StaffResponse();
//        List<com.springsecurity.example.securityexample.model.Staff> staff = staffRepository.findAll();
//
//        staffResponse.setResponseMessage("success");
//        staffResponse.setResponseCode("00");
//
//        return null;
//    }
//
//    @Override
//    public StaffResponse delete(Long id) {
//
//        StaffResponse staffResponse = new StaffResponse();
//        Optional<com.springsecurity.example.securityexample.model.Staff> staff =  staffRepository.findById(id);
//
//        if(staff != null){
//
//            staffRepository.deleteById(id);
//            staffResponse.setResponseCode("00");
//            staffResponse.setResponseMessage("deleted successfully");
//
//            return staffResponse;
//        }
//
//        staffResponse.setResponseCode("01");
//        staffResponse.setResponseMessage("staff not found");
//
//        return staffResponse;
//    }
//
//    @Override
//    public StaffResponse update(Long id, Staff staff) {
//
//        StaffResponse staffResponse = new StaffResponse();
//        Optional<com.springsecurity.example.securityexample.model.Staff> validStaff =  staffRepository.findById(id);
//
//        BeanUtils.copyProperties(staff, validStaff);
//
//        //staffRepository.saveAndFlush(validStaff);
//
//        return null;
//    }
//
//    @Override
//    public StaffResponse login(Login login) {
//        return null;
//    }
}
