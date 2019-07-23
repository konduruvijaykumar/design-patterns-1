package org.pjay.patterns.singleton;

import java.sql.*;

/**
 * @author vijayk
 */
public class DbSingletonDemo {
    public static void main(String[] args) {
        DbSingleton dbSingleton = DbSingleton.getInstance();

        long timeBefore;
        long timeAfter;

        System.out.println("dbSingleton :: " + dbSingleton);

        timeBefore = System.currentTimeMillis();
        Connection connection = dbSingleton.getConnection();
        timeAfter = System.currentTimeMillis();
        System.out.println("First Connection Call :: " + (timeAfter - timeBefore));
        System.out.println("connection :: " + connection);

        try (Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate("CREATE TABLE EMPLOYEE (ID INTEGER PRIMARY KEY, FIRST_NAME VARCHAR(30), LAST_NAME VARCHAR(30))");
            System.out.println("Table Create execute update return count :: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        timeBefore = System.currentTimeMillis();
        Connection connection1 = dbSingleton.getConnection();
        timeAfter = System.currentTimeMillis();
        System.out.println("Second Connection Call :: " + (timeAfter - timeBefore));
        System.out.println("connection1 :: " + connection1);

        String insertSql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection1.prepareStatement(insertSql)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Vijay");
            preparedStatement.setString(3, "Konduru");
            int count = preparedStatement.executeUpdate();
            System.out.println("Insert into EMPLOYEE table execute update return count :: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        timeBefore = System.currentTimeMillis();
        Connection connection2 = dbSingleton.getConnection();
        timeAfter = System.currentTimeMillis();
        System.out.println("Third Connection Call :: " + (timeAfter - timeBefore));
        System.out.println("connection2 :: " + connection2);

        String selectSql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
        try (PreparedStatement preparedStatement = connection2.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Result Info");
            while (null != resultSet && resultSet.next()) {
                System.out.println("ID :: " + resultSet.getInt("ID") + "\nFIRST_NAME :: "
                        + resultSet.getString("FIRST_NAME") + "\nLAST_NAME :: " + resultSet.getString("LAST_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
