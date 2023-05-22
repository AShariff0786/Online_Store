package com.solvd.onlinestore.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
