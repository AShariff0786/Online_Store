package com.solvd.onlinestore.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shirt extends Clothing {
    private final static Logger LOGGER = LogManager.getLogger(Shirt.class);
    private boolean isLongSleeve;

    //4-parameter constructor
    public Shirt(char size, char gender, double price) {
        super(size, gender, price);
        LOGGER.debug("New Shirt object was successfully created.");
    }

    public boolean getIsLongSleeve() {
        return isLongSleeve;
    }

    public void setIsLongSleeve(boolean isLongSleeve) {
        this.isLongSleeve = isLongSleeve;
    }

    @Override
    public String printItem() {
        if (isLongSleeve) {
            return ("This is a Long Sleeve Shirt that is Size: " + super.getSize()
                    + " Gender: " + super.getGender() + " Price: " + super.getPrice()
                    + " Brand: " + super.getBrand().getName());
        } else {
            return ("This is a Short Sleeve Shirt that is Size: " + super.getSize()
                    + " Gender: " + super.getGender() + " Price: " + super.getPrice()
                    + " Brand: " + super.getBrand().getName());
        }
    }
}
