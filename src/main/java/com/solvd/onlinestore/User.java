package com.solvd.onlinestore;

import com.solvd.onlinestore.exceptions.NameException;

public abstract class User {
    private String fullName;
    private ContactInformation contactInfo;

    public User(String fullName, ContactInformation contactInfo) {
        if (fullName.length() > 0 && fullName.length() <= 30) {
            this.fullName = fullName;
        } else {
            throw new NameException("Name is incorrect length.");
        }
        this.contactInfo = contactInfo;
    }

    public String getFullName() {
        return fullName;
    }

    public ContactInformation getContactInfo() {
        return contactInfo;
    }

    public void setFullName(String fullName) {
        if (fullName.length() > 0 && fullName.length() <= 30) {
            this.fullName = fullName;
        } else {
            throw new NameException("Name is incorrect length.");
        }
    }

    public void setContactInfo(ContactInformation contactInfo) {
        this.contactInfo = contactInfo;
    }

    public abstract void contact();

}
