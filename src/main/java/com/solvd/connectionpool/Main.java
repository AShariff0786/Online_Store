package com.solvd.connectionpool;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool= ConnectionPool.getInstance();
        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        Connection connection3 = connectionPool.getConnection();
        Connection connection4 = connectionPool.getConnection();
        Connection connection5 = connectionPool.getConnection();
        Connection connection6 = connectionPool.getConnection();
        Connection connection7 = connectionPool.getConnection();
    }
}
