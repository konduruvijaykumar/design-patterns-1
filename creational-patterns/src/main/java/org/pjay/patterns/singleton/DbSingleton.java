package org.pjay.patterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author vijayk
 */
public class DbSingleton {
    private static volatile DbSingleton dbSingleton = null;
    private static volatile Connection connection = null;

    private DbSingleton() {
        // Since 6 or later loading JDBC driver as such becomes optional.
        // The driver manager can load appropriate driver based on the database connection URL.
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Avoid creating object using reflection by throwing runtime exception
        if (null != dbSingleton) {
            throw new RuntimeException("Use getInstance() method to create object of DbSingleton");
        }

        if (null != connection) {
            throw new RuntimeException("Use getConnection() method to create object of Connection");
        }
    }

    public static DbSingleton getInstance() {
        if (null == dbSingleton) {
            synchronized (DbSingleton.class) {
                if (null == dbSingleton) {
                    dbSingleton = new DbSingleton();
                }
            }
        }
        return dbSingleton;
    }

    public Connection getConnection() {
        if (null == connection) {
            synchronized (DbSingleton.class) {
                if (null == connection) {
                    connection = null;
                    String jdbcUrl = "jdbc:derby:memory:testdb;create=true";
                    try {
                        connection = DriverManager.getConnection(jdbcUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
