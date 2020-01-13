package com.epam.vsharstuk.springboot_mvc.service.impl;

import com.epam.vsharstuk.springboot_mvc.model.Role;
import com.epam.vsharstuk.springboot_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private UserService userService;
    private UserDetails userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            com.epam.vsharstuk.springboot_mvc.model.User userByName = userService.findUserByName(username).get(0);
            List<GrantedAuthority> authorities = new ArrayList<>();

            for (Role role : userByName.getRolesList()) {
                authorities.add(new SimpleGrantedAuthority(role.name()));
            }

            UserDetails userDetails = new User(
                    userByName.getName(),
                    userByName.getPassword(),
                    authorities
            );
            this.userDetails = userDetails;
            return userDetails;
        } catch (Throwable e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}
