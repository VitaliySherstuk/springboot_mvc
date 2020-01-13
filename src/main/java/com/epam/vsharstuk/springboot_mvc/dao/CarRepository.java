package com.epam.vsharstuk.springboot_mvc.dao;

import com.epam.vsharstuk.springboot_mvc.model.Car;
import com.epam.vsharstuk.springboot_mvc.service.CarSearchCriteria;

import java.util.List;
import java.util.Map;

public interface CarRepository {

    void addCar(Car car);
    List<Car> findCarByMake(String make);
    List<Car> findCarById(Integer id);
    List<Car> findCarByUserId(Integer userId);
    List<Car> findCarByCriteria(CarSearchCriteria criteria);
    void update(Car car);
    void delete(Integer id);
    String carCount();
    List<Map<String, String>> userCarsCount();
}
