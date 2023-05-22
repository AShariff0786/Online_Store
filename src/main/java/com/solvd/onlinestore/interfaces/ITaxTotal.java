package com.solvd.onlinestore.interfaces;

@FunctionalInterface
public interface ITaxTotal {
    double taxAmount(double preTaxTotal);
}
