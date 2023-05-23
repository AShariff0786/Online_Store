package com.solvd.connectionpool;

import com.solvd.onlinestore.Cart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class Connection {
    private final static Logger LOGGER = LogManager.getLogger(Connection.class);
    private int idNum;

    public Connection(int idNum){
        this.idNum = idNum;
    }

    public int getIdNum(){
        return idNum;
    }

    public void setIdNum(int idNum){
        this.idNum = idNum;
    }

    public void runConnection(ConnectionPool connectionPool){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                LOGGER.info("Custom Thread " + idNum + " has started.");
                try {
                    Thread.sleep(5000);
                    connectionPool.releaseConnection(Connection.this);
                    LOGGER.info("Custom Thread " + idNum + " is complete.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
