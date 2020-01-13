package com.epam.vsharstuk.springboot_mvc.service.impl;


import com.epam.vsharstuk.springboot_mvc.dao.CarRepositoryImpl;
import com.epam.vsharstuk.springboot_mvc.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private CarRepositoryImpl carRepository;

    @Override
    public String getCarsCount() {
        return carRepository.carCount();
    }

    @Override
    public List<Map<String, String>> getUserCarsCount() {
        return carRepository.userCarsCount();
    }
}
