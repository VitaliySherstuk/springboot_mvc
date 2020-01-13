package com.epam.vsharstuk.springboot_mvc.service.impl;

import com.epam.vsharstuk.springboot_mvc.dao.UserRepository;
import com.epam.vsharstuk.springboot_mvc.model.User;
import com.epam.vsharstuk.springboot_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(String name, String password, String phone) {
        String encodedPass = passwordEncoder.encode(password);
        User user = new User(name, encodedPass, "ROLE_ADMIN",  phone);
        return userRepository.createUser(user);
    }

    @Override
    public List<User> findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
