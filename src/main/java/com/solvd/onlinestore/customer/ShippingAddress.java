package com.solvd.onlinestore.customer;

import com.solvd.onlinestore.interfaces.IPrint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShippingAddress implements IPrint {
    private final static Logger LOGGER = LogManager.getLogger(ShippingAddress.class);
    private String address;
    private String city;
    private String state;
    private int zipCode;

    //4-parameter constructor
    public ShippingAddress(String address, String city, String state) {
        this.address = address;
        this.city = city;
        this.state = state;
        LOGGER.debug("New Shipping Address object was successfully created.");
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public void print() {
        LOGGER.info("Address: " + address + ", City: " + city
                + ", State: " + state + ", Zip Code: " + zipCode);
    }
}
