package com.epam.vsharstuk.springboot_mvc.service.impl;

import com.epam.vsharstuk.springboot_mvc.controller.HomePageController;
import com.epam.vsharstuk.springboot_mvc.dao.CarRepository;
import com.epam.vsharstuk.springboot_mvc.model.Car;
import com.epam.vsharstuk.springboot_mvc.service.CarSearchCriteria;
import com.epam.vsharstuk.springboot_mvc.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    private Logger LOG = LogManager.getLogger(HomePageController.class);

    @Override
    public void addCar(String make, String model, String year, String cost, Integer userId) {
        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setYear(Integer.valueOf(year));
        car.setCost(Integer.valueOf(cost));
        car.setUserId(userId);
        carRepository.addCar(car);
        LOG.info("Car was added: " + car);
    }

    @Override
    public List<Car> findCarByMake(String make, String order) {

        if (make == null) {
            return Collections.emptyList();
        }

        List<Car> cars = carRepository.findCarByMake(make);

        if (order != null ) {
            return sort(cars, order);
        }
        return cars;
    }

    @Override
    public List<Car> findCarByCriteria(CarSearchCriteria criteria, String order) {

        if (criteria == null) {
            return Collections.emptyList();
        }

        List<Car> cars = carRepository.findCarByCriteria(criteria);

        if (order != null ) {
            return sort(cars, order);
        }
        return cars;
    }

    private List<Car> sort(List<Car> cars, String order) {

        switch (order) {
            case "make":
                return cars.stream().sorted(Comparator.comparing(Car::getMake)).collect(Collectors.toList());
            case "model":
                return cars.stream().sorted(Comparator.comparing(Car::getModel)).collect(Collectors.toList());
            case "year":
                return cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());
            case "cost":
                return cars.stream().sorted(Comparator.comparing(Car::getCost)).collect(Collectors.toList());
            default:
            return cars;
        }
    }

    @Override
    public List<Car> findCarById(Integer id) {
        if (id == null) {
            return Collections.emptyList();
        }
        return carRepository.findCarById(id);
    }

    @Override
    public List<Car> findCarByUserId(Integer userId) {
        if (userId == null) {
            return Collections.emptyList();
        }
        return carRepository.findCarByUserId(userId);
    }

    @Override
    public Car update(Integer id, Integer cost) {
        List<Car> cars = carRepository.findCarById(Integer.valueOf(id));
        Car car = cars.get(0);
        car.setCost(Integer.valueOf(cost));
        carRepository.update(car);
        LOG.info("Car was updated " + car);
        return  car;
    }

    @Override
    public Car update(Car car) {
        carRepository.update(car);
        LOG.info("Car was updated " + car);
        return  car;
    }

    @Override
    public void delete(Integer id) {
        carRepository.delete(id);
        LOG.info("Car with id: " + id + " was deleted ");
    }
}
