/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author TAN
 */
public class CUA_TAn {

    public java.sql.Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cse301_bankingsystem";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public String saveSavingsAccount(String accountNumber, double balance, String branchId, double interest_rate, String customerId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String result = null;

        try {

            connection = getConnection();
            connection.setAutoCommit(false);

            String sql1 = "insert into savings_account(account_number,balance,branch_id,interest_rate)"
                    + " values(?,?,?,?)";

            statement = connection.prepareStatement(sql1);
            statement.setString(1, accountNumber);
            statement.setDouble(2, balance);
            statement.setString(3, branchId);
            statement.setDouble(4, interest_rate);

            statement.executeUpdate();

            String sql2 = "insert into savings_account_customer(account_number,customer_id,last_access_date)"
                    + " values(?,?,?)";

            PreparedStatement statement2 = connection.prepareStatement(sql2);
            Date currentDate = new Date();

            statement2.setString(1, accountNumber);
            statement2.setString(2, customerId);
            statement2.setDate(3, new java.sql.Date(currentDate.getTime()));

            statement2.executeUpdate();

            String sql3 = "select account_number from savings_account where account_number = ?";
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            statement3.setString(1, accountNumber);
            resultSet = statement3.executeQuery();

            while (resultSet.next()) {
                result = resultSet.getString(1);
            }

            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("rollback");
                    return null;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public String selectLastSavingsAccountNumber() {
        String result = "";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String sql = "SELECT account_number FROM savings_account ORDER BY account_number DESC LIMIT 1";
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString(1);

            }
            return result;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    public String transferMoney(String savingsAccount, String currentAccount, Double amount) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Double savingAmount = null;
        Double currentAmount = null;
        String result = null;

        try {

            connection = getConnection();
            connection.setAutoCommit(false);

            //check value
            String sql1 = "select balance from savings_account where account_number = ? ";
            statement = connection.prepareStatement(sql1);
            statement.setString(1, savingsAccount);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                savingAmount = resultSet.getDouble("balance");
            }
            if (savingAmount < 200 || savingAmount - amount < 50) {
                return null;
            }

            String sql2 = "select balance from current_account where account_number = ? ";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement2.setString(1, currentAccount);
            resultSet = statement2.executeQuery();

            while (resultSet.next()) {
                currentAmount = resultSet.getDouble("balance");
            }

            if (currentAmount == null) {
                return null;
            }

            //minus in savings account            
            String sql3 = "update savings_account set balance = ? where account_number = ?";
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            statement3.setDouble(1, savingAmount - amount);
            statement3.setString(2, savingsAccount);
            statement3.executeUpdate();

            //plus in current account
            String sql4 = "update current_account set balance = ? where account_number = ?";
            PreparedStatement statement4 = connection.prepareStatement(sql4);
            statement4.setDouble(1, currentAmount + amount);
            statement4.setString(2, currentAccount);
            statement4.executeUpdate();

            result = "oke";

            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("rollback");
                    return null;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}