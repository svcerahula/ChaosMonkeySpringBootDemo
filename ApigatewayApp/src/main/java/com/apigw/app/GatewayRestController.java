package com.apigw.app;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.apigw.app.commands.MobilesServiceHystrixCommand;
import com.apigw.app.commands.LaptopServiceHystrixCommand;
import com.apigw.app.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class GatewayRestController {
    RestTemplate restTemplate;

    @PostConstruct
    public void initialize() {
        restTemplate = new RestTemplate();
    }

    @RequestMapping(value="/userPage",method=RequestMethod.GET)
    public ResponseEntity<Object> start() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        StartModel startModel = new StartModel();

        //get the response of mobile services application
        Future<ApiResponse> mobileServicesResponse = getMobilesService();
        Future<ApiResponse> laptopServiceResponse = getLaptopsService();

        startModel.setMobilesServiceResponse(extractData(mobileServicesResponse)); // extract mobile service data
        startModel.setLaptopServiceResponse(extractData(laptopServiceResponse)); // extract laptop service data

        startModel.setDuration(System.currentTimeMillis() - start); // set the duration of the total response got from the various services
        return new ResponseEntity<>(startModel, HttpStatus.OK);
    }


    private ApiResponse extractData(Future<ApiResponse> apiresp) throws ExecutionException, InterruptedException {
        return apiresp.get();
    }

    private Future<ApiResponse> getMobilesService() {
        return new MobilesServiceHystrixCommand(
                HystrixCommandGroupKey.Factory.asKey("mobileservice"),
                3000,restTemplate,
                "http://localhost:4443/mobileservice/mobiles").queue();
    }

    private Future<ApiResponse> getLaptopsService() {
        return new LaptopServiceHystrixCommand(
                HystrixCommandGroupKey.Factory.asKey("laptopservice"),
                3000,restTemplate,
                "http://localhost:4441/laptopservice/laptops").queue();
    }
}
