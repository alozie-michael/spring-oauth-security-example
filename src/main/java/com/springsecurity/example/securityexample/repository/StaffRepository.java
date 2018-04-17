package com.springsecurity.example.securityexample.repository;

import com.springsecurity.example.securityexample.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findByEmailContaining(String email);
}
