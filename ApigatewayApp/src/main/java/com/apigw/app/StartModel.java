package com.apigw.app;

import com.apigw.app.model.ApiResponse;

public class StartModel {

    private  ApiResponse mobileServicesResponse;
    private  ApiResponse laptopServiceResponse;
    private  long duration;

    public void setMobilesServiceResponse(ApiResponse apiresp) {
        this.mobileServicesResponse = apiresp;
    }

    public void setLaptopServiceResponse(ApiResponse apiresp) {
        this.laptopServiceResponse = apiresp;
    }

    public ApiResponse getMobileServicesResponse() {
        return mobileServicesResponse;
    }

    public ApiResponse getLaptopServiceResponse() {
        return laptopServiceResponse;
    }

    public void setDuration(long timeInMillis) {
        this.duration = timeInMillis;
    }

    public long getDuration() {
        return duration;
    }
}
