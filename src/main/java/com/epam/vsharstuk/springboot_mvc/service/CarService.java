package com.epam.vsharstuk.springboot_mvc.service;

import com.epam.vsharstuk.springboot_mvc.model.Car;

import java.util.List;

public interface CarService {

    void addCar(String make, String model, String year, String cost, Integer userId);
    List<Car> findCarByMake(String make, String order);
    List<Car> findCarById(Integer id);
    List<Car>findCarByUserId(Integer userId);
    List<Car> findCarByCriteria(CarSearchCriteria criteria, String order);
    Car update(Integer id, Integer cost);
    Car update(Car car);
    void delete(Integer id);
}
