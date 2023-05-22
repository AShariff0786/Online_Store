package com.solvd.onlinestore.product;

import com.solvd.onlinestore.exceptions.PriceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Handbag extends Clothing {
    private final static Logger LOGGER = LogManager.getLogger("Handbag.class");
    private String material;
    private String style;
    private double price;
    private Brand brand;

    //1-parameter constructor
    public Handbag(double price) {
        super(price);
        LOGGER.debug("New Handbag object successfully created.");
    }

    public String getMaterial() {
        return material;
    }

    public String getStyle() {
        return style;
    }

    public double getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new PriceException("Invalid Price was entered.");
        }
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }


    public void setMaterial(String material) {
        this.material = material;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String printItem() {
        return ("This is a Handbag made of: " + material
                + "Style" + style + " Price: " + super.getPrice()
                + " Brand: " + super.getBrand().getName());
    }

}
