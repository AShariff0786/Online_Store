package com.solvd.onlinestore.product;

import com.solvd.onlinestore.exceptions.GenderException;
import com.solvd.onlinestore.exceptions.PriceException;
import com.solvd.onlinestore.exceptions.SizeException;

public abstract class Clothing {
    private char size;
    private char gender;
    private double price;
    private Brand brand;

    //1-parameter constructor
    public Clothing(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new PriceException("Invalid price was entered.");
        }
    }

    //3-parameter constructor
    public Clothing(char size, char gender, double price) {
        if (size == 'S' || size == 'M' || size == 'L') {
            this.size = size;
        } else {
            throw new SizeException("Invalid value was entered for size.");
        }
        if (gender == 'M' || gender == 'F') {
            this.gender = gender;
        } else {
            throw new GenderException("Invalid value was entered for gender.");
        }
        if (price > 0) {
            this.price = price;
        } else {
            throw new PriceException("Invalid price was entered.");
        }
    }

    public char getSize() {
        return size;
    }

    public char getGender() {
        return gender;
    }

    public double getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setSize(char size) {
        if (size == 'S' || size == 'M' || size == 'L') {
            this.size = size;
        } else {
            throw new SizeException("Invalid value was entered for size.");
        }
    }

    public void setGender(char gender) {
        if (gender == 'M' || gender == 'F') {
            this.gender = gender;
        } else {
            throw new GenderException("Invalid value was entered for gender.");
        }
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new PriceException("Invalid price was entered.");
        }
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public abstract String printItem();

}
