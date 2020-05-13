package com.mobileapp.app;

public class Mobiles {
    private final long price;
    private final String modelName;
    private final String manufacturer;

    public Mobiles(long price, String modelName, String manufacturer) {
        this.price = price;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
    }

    public long getPrice() {
        return price;
    }

    public String getModelName() {
        return modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
