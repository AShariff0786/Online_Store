package com.solvd.onlinestore.product;

import com.solvd.onlinestore.exceptions.SizeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shoes extends Clothing {
    private final static Logger LOGGER = LogManager.getLogger("Shoes.class");
    private int shoeSize;

    //4-parameter constructor
    public Shoes(int shoeSize, char gender, double price) {
        super(price);
        super.setGender(gender);
        if (shoeSize > 0 && shoeSize <= 20) {
            this.shoeSize = shoeSize;
        } else {
            throw new SizeException("Invalid shoe size was entered.");
        }
        LOGGER.debug("New Shoes object was successfully created.");
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setSize(int shoeSize) {
        if (shoeSize > 0 && shoeSize <= 20) {
            this.shoeSize = shoeSize;
        } else {
            throw new SizeException("Invalid shoe size was entered.");
        }
    }


    @Override
    public String printItem() {
        return ("Size: " + shoeSize + " Gender: " + super.getGender()
                + " Brand: " + super.getBrand().getName() + " Price: " + super.getPrice());
    }
}
