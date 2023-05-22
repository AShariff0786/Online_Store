package com.solvd.onlinestore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class Invoice {
    private final static Logger LOGGER = LogManager.getLogger(Invoice.class);

    public final static void printInvoice(Cart cart) {
        IntStream.range(0,cart.getItems().size()).forEach(index ->{
            LOGGER.info(cart.getItems().get(index).printItem());
        });
        LOGGER.info("Cart Total: " + cart.getCartTotal());
    }
}
