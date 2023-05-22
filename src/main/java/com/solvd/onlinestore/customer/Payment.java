package com.solvd.onlinestore.customer;

import com.solvd.onlinestore.exceptions.CreditCardException;
import com.solvd.onlinestore.interfaces.IPrint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Payment implements IPrint {
    private final static Logger LOGGER = LogManager.getLogger(Payment.class);
    private String creditCardNum;
    private String creditCardCsc;

    public Payment(){}

    //2-parameter constructor
    public Payment(String creditCardNum, String creditCardCsc) {
        if (creditCardNum.length() == 16) {
            this.creditCardNum = creditCardNum;
        } else {
            LOGGER.debug("Payment object was unable to be created");
            throw new CreditCardException("Invalid Credit Card Number.");
        }
        if (creditCardCsc.length() == 3) {
            this.creditCardCsc = creditCardCsc;
        } else {
            LOGGER.debug("Payment object was unable to be created");
            throw new CreditCardException("Invalid CSC number entered.");
        }
        LOGGER.debug("New Payment class was successfully created.");
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public String getCreditCardCsc() {
        return creditCardCsc;
    }

    public void setCreditCardNum(String creditCardNum) {
        if (creditCardNum.length() == 16) {
            this.creditCardNum = creditCardNum;
        } else {
            throw new CreditCardException("Invalid Credit Card Number.");
        }
    }

    public void setCreditCardCsc(String creditCardCsc) {
        if (creditCardCsc.length() == 3) {
            this.creditCardCsc = creditCardCsc;
        } else {
            throw new CreditCardException("Invalid CSC number entered.");
        }
    }

    @Override
    public void print() {
        LOGGER.info("Credit Card Number: " + creditCardNum);
        LOGGER.info("Credit Card Csc: " + creditCardCsc);
    }
}
