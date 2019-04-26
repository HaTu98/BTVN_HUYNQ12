package com.itlap.spring_mvc.service.impl;

import com.itlap.spring_mvc.model.User;
import com.itlap.spring_mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = userRepository.findByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        org.springframework.security.core.userdetails.User  user = new org.springframework.security.core.userdetails.User(userInfo.getUsername(),userInfo.getPassword(), Arrays.asList(authority));
        return (UserDetails)user;
    }
}
