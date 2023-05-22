package com.solvd.onlinestore.enums;

public enum SalesTax {
    FOUR_PERCENT(0.04),
    FIVE_PERCENT(0.05),
    SIX_PERCENT(0.06),
    SEVEN_PERCENT(0.07);
    private double percentage;
    SalesTax(double percentage){
        this.percentage = percentage;
    }
    public double getPercentage() {
        return percentage;
    }
}
