package com.solvd.onlinestore.enums;

public enum Discount {
    NO_DISCOUNT(0),
    FIVE_PERCENT(0.05),
    FIFTEEN_PERCENT(0.15),
    THIRTY_PERCENT(0.30),
    FIFTY_PERCENT(0.50);

    private double discountPercentage;

    Discount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
