package com.epam.vsharstuk.springboot_mvc.controller;

import com.epam.vsharstuk.springboot_mvc.model.Car;
import com.epam.vsharstuk.springboot_mvc.model.User;
import com.epam.vsharstuk.springboot_mvc.service.CarService;
import com.epam.vsharstuk.springboot_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/orders")
public class OrderPageController {

    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getOrderPage(@CookieValue("userName") String userName, Model model) {
        if (userName != null) {
            model.addAttribute("userNameStatus", true);
            model.addAttribute("userName", userName);
        }
        return "orders";
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public String getCarCard(@PathVariable(value="id") String id, Model model) {
        Car car = carService.findCarById(Integer.valueOf(id)).get(0);
        User user = userService.findUserById(car.getUserId()).get(0);
        model.addAttribute("car", car);
        model.addAttribute("user", user);
        return "orders";
    }

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> downLoadPhoto(@PathVariable(value = "id") @NotNull Integer id) throws IOException {
        Car car = carService.findCarById(id).get(0);
        String carImgName = car.getImg();
        String path = "d:/photo/";
        byte[] data = Files.readAllBytes(Paths.get(path + carImgName));
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + carImgName)
                .contentType(MediaType.IMAGE_JPEG).contentLength(data.length)
                .body(resource);

    }
}
