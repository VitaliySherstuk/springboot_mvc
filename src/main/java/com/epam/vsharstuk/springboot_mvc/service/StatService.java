package com.epam.vsharstuk.springboot_mvc.service;

import java.util.List;
import java.util.Map;

public interface StatService {

    String getCarsCount();

    List<Map<String, String>> getUserCarsCount();
}
