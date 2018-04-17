package com.springsecurity.example.securityexample.service;

import com.springsecurity.example.securityexample.model.Staff;
import com.springsecurity.example.securityexample.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StaffRepository staffRepository;

    @Autowired
    public CustomUserDetailsService(StaffRepository staffRepository) { this.staffRepository = staffRepository;
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Staff> staff = staffRepository.findByEmailContaining(username);

        staff.orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return staff.map(CustomUserDetails::new).get();
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Staff staff = staffRepository.findByEmailContaining(username);
        if (staff == null)
        {
            throw new UsernameNotFoundException("user not found");
        }

        Set<SimpleGrantedAuthority> grantedAuthorities =
                Arrays
                        .stream(StringUtils.commaDelimitedListToStringArray(staff.getRoles()))
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

        return new User(staff.getEmail(), staff.getPassword(), grantedAuthorities);
    }

   /* public static void main(String[] args) {
        String gensalt = BCrypt.gensalt();
        System.out.println("args = [" +  BCrypt.hashpw("password",gensalt) + "]");
    }*/
}
