package com.solvd.onlinestore.product;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Brand {
    private final static Logger LOGGER = LogManager.getLogger(Brand.class);
    private String name;

    //1-parameter constructor
    public Brand(String name) {
        LOGGER.debug("New Brand object was successfully created.");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
