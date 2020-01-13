package com.epam.vsharstuk.springboot_mvc.controller;

import com.epam.vsharstuk.springboot_mvc.model.User;
import com.epam.vsharstuk.springboot_mvc.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Controller
@RequestMapping("/registration")
public class RegistrationPageController {

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;

    private Logger LOG = LogManager.getLogger(HomePageController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@RequestParam(value = "name") String name,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "phone") String phone, Model model) {
        User user = userService.createUser(name, password, phone);
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (CollectionUtils.isNotEmpty(violations)) {
            violations.stream().forEach(item -> {
                String propertyPath = item.getPropertyPath().toString();
                String message = item.getMessage();
                model.addAttribute(propertyPath + "_error", true);
                model.addAttribute(propertyPath, message);
            });
            LOG.info("User was not registered:" + user);
            return "registration";
        }
        LOG.info("User was registered:" + user);
        return "login";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOG.warn(e);
    }
}
