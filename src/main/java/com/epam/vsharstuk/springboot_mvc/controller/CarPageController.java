package com.epam.vsharstuk.springboot_mvc.controller;

import com.epam.vsharstuk.springboot_mvc.model.Car;
import com.epam.vsharstuk.springboot_mvc.service.CarSearchCriteria;
import com.epam.vsharstuk.springboot_mvc.service.CarService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarPageController {

    @Autowired
    private CarService carService;

    private Logger LOG = LogManager.getLogger(HomePageController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getCarPage(@CookieValue("userName") String userName, Model model) {
        if (userName != null) {
            model.addAttribute("userNameStatus", true);
            model.addAttribute("userName", userName);
        }
        return "cars";
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public String findCarsByMake(@RequestParam(value="make") String make,
                                 @RequestParam(value="model") String model,
                                 @RequestParam(value="year") String year,
                                 @RequestParam(value="cost") String cost,
                                 @RequestParam(value ="order", required = false) String order, Model m) {
        CarSearchCriteria criteria = new CarSearchCriteria();
        criteria.setMake(make);
        criteria.setModel(model);

        if (StringUtils.isNoneBlank(year)) {
            criteria.setYear(Integer.valueOf(year));
        }

        if (StringUtils.isNoneBlank(cost)) {
            criteria.setCost(Integer.valueOf(cost));
        }

        List<Car> cars = carService.findCarByCriteria(criteria, order);
        if(cars != null)
        {
            m.addAttribute("cars", cars);
            m.addAttribute("isVisible", true);
        }
        return "cars";
    }

    @RequestMapping(value = "/removed/{id}", method = RequestMethod.GET)
    public String findCarsByMake(@PathVariable(value="id") String id) {
        carService.delete(Integer.valueOf(id));
        return "cars";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
