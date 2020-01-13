package com.epam.vsharstuk.springboot_mvc.controller;

import com.epam.vsharstuk.springboot_mvc.model.Car;
import com.epam.vsharstuk.springboot_mvc.service.CarService;
import com.epam.vsharstuk.springboot_mvc.service.UserService;
import com.epam.vsharstuk.springboot_mvc.service.impl.UserDetailsServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryPageController {

    @Autowired
    private CarService carService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserService userService;

    private Logger LOG = LogManager.getLogger(HomePageController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getInventoryPage(@CookieValue("userName") String userName, Model model) {
        String name = userDetailsService.getUserDetails().getUsername();
        Integer userId =userService.findUserByName(name).get(0).getId();
        List<Car> cars = carService.findCarByUserId(userId);

        if (userName != null) {
            model.addAttribute("userNameStatus", true);
            model.addAttribute("userName", userName);
        }

        if (CollectionUtils.isNotEmpty(cars)) {
            model.addAttribute("isVisible", true);
            model.addAttribute("cars", cars);
        }
        return "inventory";
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String addCar(@RequestParam(value = "make") String make,
                         @RequestParam(value = "model") String model,
                         @RequestParam(value = "year") String year,
                         @RequestParam(value = "cost") String cost) {

        String username = userDetailsService.getUserDetails().getUsername();
        Integer userId = userService.findUserByName(username).get(0).getId();
        carService.addCar(make, model, year, cost, userId);
        LOG.info("Car was added for " + username);
        return "redirect:/inventory";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "BAD request")
    @ExceptionHandler(NumberFormatException.class)
    public void handleNumberFormatException(NumberFormatException e) {
        LOG.warn(e);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
