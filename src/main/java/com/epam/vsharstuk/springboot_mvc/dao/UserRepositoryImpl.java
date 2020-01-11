package com.epam.vsharstuk.springboot_mvc.dao;

import com.epam.vsharstuk.springboot_mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<User> userRowMapper = (resultSet, rowNum) ->{
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        user.setRoles(resultSet.getString("role"));
        user.setPhone(resultSet.getString("phone"));
        return user;
    };

    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO users (name, password, role, phone) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getRoles(), user.getPhone());
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {
        String sql = "SELECT id, name, password, role, phone FROM users WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, userRowMapper);
    }

    @Override
    public List<User> findUserById(Integer id) {
        String sql = "SELECT id, name, password, role, phone FROM users WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, userRowMapper);
    }
}
