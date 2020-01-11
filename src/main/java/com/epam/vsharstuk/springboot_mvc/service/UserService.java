package com.epam.vsharstuk.springboot_mvc.service;

import com.epam.vsharstuk.springboot_mvc.model.User;

import java.util.List;

public interface UserService {

    User createUser(String name, String password, String phone);
    List<User> findUserById(Integer id);
    List<User> findUserByName(String name);
}
