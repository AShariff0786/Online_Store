package com.solvd.connectionpool;

import com.solvd.onlinestore.Cart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool;
    private static int numConnections;
    private static List<Connection> connections = new ArrayList<>();

    private ConnectionPool(){}
    public static ConnectionPool getInstance(){
        if(connectionPool == null){
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public static int getNumConnections() {
        return numConnections;
    }

    public Connection getConnection(){
        Connection temp;
        while(numConnections > 4){
            LOGGER.info("Unable to get connection at this moment.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error("Thread was unable to put to sleep");
                throw new RuntimeException(e);
            }
        }
        if(connections.isEmpty()) {
            temp = new Connection(numConnections);
        }else{
            LOGGER.info("Successfully reused connection.");
            temp = connections.get(0);
            connections.remove(0);
        }
        addCounter();
        temp.runConnection();
        return temp;
    }
    public static void releaseConnection(Connection connection){
        connections.add(connection);
        if(numConnections > 0) {
            subtractCounter();
        }
    }
    public static synchronized void addCounter(){
        numConnections++;
    }
    public static synchronized void subtractCounter(){
        numConnections--;
    }
}
