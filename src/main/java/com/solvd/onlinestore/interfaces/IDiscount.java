package com.solvd.onlinestore.interfaces;

@FunctionalInterface
public interface IDiscount {
    double discount(double initalPrice);
}
