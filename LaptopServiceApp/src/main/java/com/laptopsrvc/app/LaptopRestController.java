package com.laptopsrvc.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LaptopRestController {

    List<Laptops> laptopList = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        Laptops samsung_s9 = new Laptops(40000,"Inspiron","DELL");
        laptopList.add(samsung_s9);
        Laptops apple_iphone11 = new Laptops(60000,"T470","Lenovo");
        laptopList.add(apple_iphone11);
    }

    @RequestMapping(value="laptopservice/laptops",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getMobiles() {
        return new ResponseEntity<>(laptopList, HttpStatus.OK);
    }
}
