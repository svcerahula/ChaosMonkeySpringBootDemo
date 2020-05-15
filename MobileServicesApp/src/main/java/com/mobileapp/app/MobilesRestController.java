package com.mobileapp.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MobilesRestController {

    List<Mobiles> mobilesList = new ArrayList<>();

    @PostConstruct
    public void initialize() {
        Mobiles samsung_s9 = new Mobiles(40000,"S9","Samsung");
        mobilesList.add(samsung_s9);
        Mobiles apple_iphone11 = new Mobiles(60000,"Iphone11","Apple");
        mobilesList.add(apple_iphone11);
    }

    @RequestMapping(value="mobileservice/mobiles",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getMobiles() {
        return new ResponseEntity<>(mobilesList, HttpStatus.OK);
    }

}
