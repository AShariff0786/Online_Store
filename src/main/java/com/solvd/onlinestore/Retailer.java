package com.solvd.onlinestore;

import com.solvd.onlinestore.customer.Order;
import com.solvd.onlinestore.interfaces.ILogin;
import com.solvd.onlinestore.interfaces.ILogout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class Retailer extends User implements ILogin, ILogout {
    private final static Logger LOGGER = LogManager.getLogger(Retailer.class);
    private double profit;
    private double loss;
    private static ArrayList<Order> unfulfilledOrders = new ArrayList<>();
    private HashMap<Integer, String> employees = new HashMap<Integer, String>();

    public Retailer(String name, ContactInformation retailInfo) {
        super(name, retailInfo);
        LOGGER.debug("New Retailer object was successfully created.");
    }

    public ArrayList<Order> getUnfulfilledOrders() {
        return unfulfilledOrders;
    }

    public double getProfit() {
        return profit;
    }

    public double getLoss() {
        return loss;
    }

    public HashMap<Integer, String> getEmployees() {
        return employees;
    }

    public void setEmployees(HashMap<Integer, String> employees) {
        this.employees = employees;
    }

    public void setUnfulfilledOrders(ArrayList<Order> unfulfilledOrders) {
        this.unfulfilledOrders = unfulfilledOrders;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void setLoss(double loss) {
        this.loss = loss;
    }

    @Override
    public void contact() {
        LOGGER.info("Contact our company at:\n Email: " + super.getContactInfo().getEmail()
                + "\nPhone Number: " + super.getContactInfo().getPhoneNum());
    }

    public void contactUser(User u) {
        u.contact();
    }

    @Override
    public final void login() {
        LOGGER.info("The Retail Employee successfully logged into their account.");
    }

    @Override
    public final void logout() {
        LOGGER.info("The Retail Employee successfully logged out their account.");
    }

    public static int numOpenOrders() {
        return unfulfilledOrders.size();
    }

    public void addEmployee(Integer employeeID, String name) {
        employees.put(employeeID, name);
    }

    public void removeEmployee(Integer employeeID) {
        employees.remove(employeeID);
    }

    public void addUnfulfilledOrder(Order o) {
        unfulfilledOrders.add(o);
    }

    public void removeUnfulfilledOrder(Order o) {
        unfulfilledOrders.remove(o);
    }
}
