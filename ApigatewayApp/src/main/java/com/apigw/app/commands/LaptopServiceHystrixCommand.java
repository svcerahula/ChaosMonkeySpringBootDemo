package com.apigw.app.commands;

import com.apigw.app.model.ApiResponse;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class LaptopServiceHystrixCommand extends HystrixCommand<ApiResponse> {

    private final RestTemplate restTemplate;
    private final String url;

    public LaptopServiceHystrixCommand(HystrixCommandGroupKey group, int timeout, RestTemplate restTemplate, String url) {
        super(group, timeout);
        this.restTemplate = restTemplate;
        this.url = url;
    }

    protected ApiResponse run() throws Exception {
        ApiResponse resp = new ApiResponse();
        resp.setApiResponseOject(Arrays.asList(restTemplate.getForObject(url,Object.class)));
        resp.setResponseType("REMOTE");
        return resp;
    }

    @Override
    protected ApiResponse getFallback() {
        ApiResponse resp = new ApiResponse();
        resp.setResponseType("FALLBACK");
        return resp;
    }
}
