package com.solvd.onlinestore.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hat extends Clothing {
    private final static Logger LOGGER = LogManager.getLogger(Hat.class);
    private String style;

    //2-parameter constructor
    public Hat(char size, String style, double price) {
        super(price);
        super.setSize(size);
        this.style = style;
        LOGGER.debug("New Hat object was successfully created.");
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }


    @Override
    public String printItem() {
        return ("Size: " + super.getSize() + " Style: " + style
                + " Price: " + super.getPrice());
    }
}
