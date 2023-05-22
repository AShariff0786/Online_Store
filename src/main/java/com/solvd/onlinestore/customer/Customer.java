package com.solvd.onlinestore.customer;

import com.solvd.onlinestore.*;
import com.solvd.onlinestore.interfaces.ILogin;
import com.solvd.onlinestore.interfaces.ILogout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;

public class Customer extends User implements ILogin, ILogout {
    private final static Logger LOGGER = LogManager.getLogger(Customer.class);
    private ArrayList<ShippingAddress> shippingInfo = new ArrayList<>();
    private HashSet<Payment> creditCards = new HashSet<>();
    private HashSet<Order> orders = new HashSet<>();

    //2-parameter constructor
    public Customer(String name, ContactInformation customerInfo) {
        super(name, customerInfo);
        LOGGER.debug("New Customer object successfully created.");
    }

    public ArrayList<ShippingAddress> getShippingInfo() {
        return shippingInfo;
    }

    public HashSet<Payment> getCreditCards() {
        return creditCards;
    }

    public HashSet<Order> getOrders() {
        return orders;
    }

    public void setShippingInfo(ArrayList<ShippingAddress> shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public void setOrders(HashSet<Order> orders) {
        this.orders = orders;
    }

    public void setCreditCards(HashSet<Payment> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public void contact() {
        LOGGER.info("The Customers Email: " + super.getContactInfo().getEmail()
                + "\nPhone Number: " + super.getContactInfo().getPhoneNum());
    }

    @Override
    public final void login() {
        LOGGER.info("Customer successfully logged into their account.");
    }

    @Override
    public final void logout() {
        LOGGER.info("Customer successfully logged out of their account.");
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void removeOrder(Order o) {
        orders.remove(o);
    }

    public void addCreditCard(Payment p) {
        creditCards.add(p);
    }

    public void removeCreditCard(Payment p) {
        creditCards.remove(p);
    }

    public void addAddress(ShippingAddress address) {
        shippingInfo.add(address);
    }

    public void removeAddress(ShippingAddress address) {
        shippingInfo.remove(address);
    }
}
