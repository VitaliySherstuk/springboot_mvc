package com.epam.vsharstuk.springboot_mvc.dao;

import com.epam.vsharstuk.springboot_mvc.model.Car;
import com.epam.vsharstuk.springboot_mvc.service.CarSearchCriteria;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepositoryImpl implements  CarRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<Car> carRowMapper = (resultSet, rowNum) ->{
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setMake(resultSet.getString("make"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getInt("year"));
        car.setCost(resultSet.getInt("cost"));
        car.setUserId(resultSet.getInt("user_id"));
        car.setImg(resultSet.getString("img"));
        return car;
    };


    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO cars (make, model, year, cost, user_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getYear(), car.getCost(), car.getUserId());
    }

    @Override
    public List<Car> findCarByMake(String make) {
        String sql = "SELECT id, make, model, year, user_id, cost, img FROM cars WHERE make = ?";
        return jdbcTemplate.query(sql, new Object[]{make}, carRowMapper);
    }

    @Override
    public List<Car> findCarById(Integer id) {
        String sql = "SELECT id, make, model, year, user_id, cost, img FROM cars WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, carRowMapper);
    }

    @Override
    public List<Car> findCarByUserId(Integer userId) {
        String sql = "SELECT id, make, model, year, user_id, cost, img FROM cars WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, carRowMapper);
    }

    @Override
    public List<Car> findCarByCriteria(CarSearchCriteria criteria) {
        StringBuilder builder = new StringBuilder();
        String sql = "SELECT id, make, model, year, user_id, cost, img FROM cars ";
        List<Object> parameters = new ArrayList<>();
        builder.append(sql);
        boolean isFirstStatement = false;

        if (StringUtils.isNoneBlank(criteria.getMake())) {
            isFirstStatement = isFirstStatement(parameters, builder, isFirstStatement);
            builder = addParameter(parameters, builder, "make=");
            parameters.add(criteria.getMake());
        }

        if (StringUtils.isNoneBlank(criteria.getModel())) {
            isFirstStatement = isFirstStatement(parameters, builder, isFirstStatement);
            builder =  addParameter(parameters, builder, "model=");
            parameters.add(criteria.getModel());
        }

        if (criteria.getYear() != null) {
            isFirstStatement = isFirstStatement(parameters, builder, isFirstStatement);
            builder = addParameter(parameters, builder, "year=");
            parameters.add(criteria.getYear());
        }

        if (criteria.getCost() != null) {
            isFirstStatement(parameters, builder, isFirstStatement);
            builder = addParameter(parameters, builder, "cost>");
            parameters.add(criteria.getCost());
        }

        if (CollectionUtils.isNotEmpty(parameters)) {
            Object[] objects = parameters.toArray();
            return jdbcTemplate.query(builder.toString(), objects, carRowMapper);
        }

        return jdbcTemplate.query(sql, carRowMapper);
    }

    private boolean isFirstStatement(List<Object> parameters, StringBuilder builder, boolean isFirstStatement) {

        if (!isFirstStatement && CollectionUtils.isEmpty(parameters)) {
            builder.append("WHERE ");
            return true;
        }
        return isFirstStatement;
    }

    private StringBuilder addParameter(List<Object> parameters, StringBuilder builder, String parameter) {
        builder = CollectionUtils.isNotEmpty(parameters) ? builder.append(" and " + parameter + "?") : builder.append(parameter + "?");
        return builder;
    }

    @Override
    public void update(Car car) {
        String sql = "UPDATE cars SET cost = " + car.getCost() + ", img = '" + car.getImg() + "' WHERE id = " + car.getId();
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE cars WHERE id = " + id;
        jdbcTemplate.update(sql);
    }
}
