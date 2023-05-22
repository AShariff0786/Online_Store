package com.solvd.onlinestore.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pants extends Clothing {
    private final static Logger LOGGER = LogManager.getLogger(Pants.class);
    private boolean isShortPants;

    //3-parameter constructor
    public Pants(char size, char gender, double price) {
        super(size, gender, price);
        LOGGER.debug("New Pants Object was successfully created.");
    }

    public boolean getIsShortPants() {
        return isShortPants;
    }

    public void setIsShortPants(boolean isShortPants) {
        this.isShortPants = isShortPants;
    }


    @Override
    public String printItem() {
        if (isShortPants) {
            return ("This is a Short Pants that is Size: " + super.getSize()
                    + " Gender: " + super.getGender() + " Price: " + super.getPrice()
                    + " Brand: " + super.getBrand().getName());
        } else {
            return ("This is a Long Pants that is Size: " + super.getSize()
                    + " Gender: " + super.getGender() + " Price: " + super.getPrice()
                    + " Brand: " + super.getBrand().getName());
        }
    }
}
