package com.solvd.onlinestore;

import com.solvd.onlinestore.interfaces.IPrint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContactInformation {
    private final static Logger LOGGER = LogManager.getLogger(ContactInformation.class);
    private String email;
    private String phoneNum;

    //2-parameter constructor
    public ContactInformation(String email, String phoneNum) {
        this.email = email;
        this.phoneNum = phoneNum;
        LOGGER.debug("New ContactInformation object successfully created.");
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


}
