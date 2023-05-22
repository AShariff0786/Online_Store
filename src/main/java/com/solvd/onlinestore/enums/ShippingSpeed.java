package com.solvd.onlinestore.enums;

public enum ShippingSpeed {
    FREE_SHIPPING(5, 0.00),
    ONE_DAY_SHIPPING(1, 9.99),
    TWO_DAY_SHIPPING(2, 7.99),
    DEFAULT_SHIPPING(5, 5.99);

    private int numDays;
    private double price;

    ShippingSpeed(int numDays, double price) {
        this.numDays = numDays;
        this.price = price;
    }

    public int getNumDays() {
        return numDays;
    }

    public double getPrice() {
        return price;
    }
}
