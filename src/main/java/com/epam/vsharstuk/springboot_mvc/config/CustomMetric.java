package com.epam.vsharstuk.springboot_mvc.config;

import com.epam.vsharstuk.springboot_mvc.service.impl.StatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Endpoint(id = "stat")
public class CustomMetric {

    @Autowired
    private StatServiceImpl statService;

    @ReadOperation
    public Map<String, String> readOperation() {
        String carsCount = statService.getCarsCount();
        List<Map<String, String>> userCarsCount = statService.getUserCarsCount();
        Map<String, String> stat = new HashMap<>();
        stat.put("date", LocalDateTime.now().toString());
        stat.put("allCars", carsCount);
        stat.put("userCarsCount", userCarsCount.toString());
        return stat;
    }

    @WriteOperation
    public String configureFeature() {
        return "";
    }

    @DeleteOperation
    public String deleteFeature() {
        return "";
    }

}
