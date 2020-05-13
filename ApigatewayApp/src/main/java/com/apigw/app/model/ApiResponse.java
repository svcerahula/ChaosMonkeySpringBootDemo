package com.apigw.app.model;

import java.util.List;

public class ApiResponse {

    private List<Object> apiRespObject;
    private String respType;

    public List<Object> getApiResonseObject() {
        return apiRespObject;
    }

    public void setApiResponseOject(List<Object> apiRespObject) {
        this.apiRespObject = apiRespObject;
    }

    public String getResponseType() {
        return respType;
    }

    public void setResponseType(String respType) {
        this.respType= respType;
    }
}
