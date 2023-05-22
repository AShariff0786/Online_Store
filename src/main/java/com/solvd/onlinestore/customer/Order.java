package com.solvd.onlinestore.customer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Order {
    private final static Logger LOGGER = LogManager.getLogger(Order.class);
    private String orderNumber;

    public Order(){}

    //1-parameter constructor
    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
        LOGGER.debug("New Order object was successfully created.");
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


}
