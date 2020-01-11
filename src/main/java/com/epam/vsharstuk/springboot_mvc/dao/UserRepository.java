package com.epam.vsharstuk.springboot_mvc.dao;

import com.epam.vsharstuk.springboot_mvc.model.User;

import java.util.List;

public interface UserRepository {

    User createUser(User user);
    List<User> findUserByName(String name);
    List<User> findUserById(Integer id);
}
