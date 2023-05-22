package com.solvd.onlinestore;

import com.solvd.onlinestore.enums.ShippingSpeed;
import com.solvd.onlinestore.exceptions.PriceException;
import com.solvd.onlinestore.interfaces.*;
import com.solvd.onlinestore.product.Clothing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.util.function.Function;
import java.util.function.Predicate;

public final class Cart implements IAddItem, IRemoveItem {
    private final static Logger LOGGER = LogManager.getLogger(Cart.class);
    private double cartTotal;
    private double finalTotal;
    private static int numItems;
    private boolean freeShipping;
    private double discount;
    private GenericLinkedList<Clothing> items = new GenericLinkedList<>();

    //default constructor
    public Cart() {
        cartTotal = 0;
        numItems = 0;
        LOGGER.debug("New Cart object was successfully created.");
    }

    //1-parameter constructor
    public Cart(Clothing c) {
        items.add(c);
        cartTotal += c.getPrice();
        numItems++;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public int getNumItems() {
        return numItems;
    }

    public GenericLinkedList<Clothing> getItems() {
        return items;
    }


    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public void setItems(GenericLinkedList<Clothing> items) {
        this.items = items;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    //adds to the total amount when new item is added to cart
    public void addTotalAmount(double price) {
        if (price > 0) {
            cartTotal += price;
        } else {
            throw new PriceException("Invalid price was added");
        }
    }

    @Override
    public void addItem(Clothing c) {
        items.add(c);
        cartTotal += c.getPrice();
        numItems++;

    }

    @Override
    public void removeItem(Clothing c) {
        items.remove(c);
        cartTotal -= c.getPrice();
        numItems--;
    }

    public void qualifiesFreeShipping(Predicate<Double> qualifies){
        if(qualifies.test(cartTotal)) {
            freeShipping = true;
        }
    }

    public GenericLinkedList<Clothing> filterByPrice(Function<GenericLinkedList<Clothing>, GenericLinkedList<Clothing>> input){
        return input.apply(items);
    }
    public double calculateDiscountPrice(IDiscount discountTotal){
        double result;
        DecimalFormat df = new DecimalFormat("0.00");
        result = discountTotal.discount(discount);
        result = Double.parseDouble(df.format(result));
        return result;
    }

    public double calculateFinalPrice(ITaxTotal taxCost, double preTaxTotal, double shippingPrice){
        double result = preTaxTotal + shippingPrice;
        DecimalFormat df = new DecimalFormat("0.00");
        result = taxCost.taxAmount(result);
        result = Double.parseDouble(df.format(result));
        return result;
    }

    public void printItem(IPrint item){
        item.print();
    }

}
