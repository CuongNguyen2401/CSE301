package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PaymentModel;

/**
 *
 * @author ACER
 */
public class PaymentDAO extends AbstractDAO<PaymentModel> {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bankingxyz";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public String paymenWithSavingAccount(String savingsAccount, int loan_number, Double amount) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        Double savingAmount = null;
        Float loanAmount = null;
        String result = null;

        try {

            connection = getConnection();
            connection.setAutoCommit(false);

            String sql1 = "select balance from savings_account where account_number = ? ";
            statement = connection.prepareStatement(sql1);
            statement.setString(1, savingsAccount);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                savingAmount = resultSet.getDouble("balance");
            }

            if (savingsAccount == null) {
                return null;
            }
            if (savingAmount - amount <= 50) {
                return "lessthan50";
            }
            String sql2 = "select loan_amount from loan where loan_number = ? ";
            statement2 = connection.prepareStatement(sql2);
            statement2.setInt(1, loan_number);
            resultSet = statement2.executeQuery();

            while (resultSet.next()) {
                loanAmount = resultSet.getFloat("loan_amount");
            }

            if (loanAmount - amount < 0) {
                return "justneedtopayenough";
            }
            if (loanAmount == null) {
                return null;
            }

            //minus in savings account            
            String sql3 = "update savings_account set balance = ? where account_number = ?";
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            statement3.setDouble(1, savingAmount - amount);
            statement3.setString(2, savingsAccount);
            statement3.executeUpdate();

            String sql4 = "update loan set loan_amount = ? where loan_number = ?";
            PreparedStatement statement4 = connection.prepareStatement(sql4);
            statement4.setDouble(1, loanAmount - amount);
            statement4.setInt(2, loan_number);
            statement4.executeUpdate();

            String sql5 = "INSERT INTO payment (loan_number, payment_date, amount) VALUES (?, CURRENT_TIMESTAMP, ?)";
            PreparedStatement statement5 = connection.prepareStatement(sql5);
            statement5.setInt(1, loan_number);
            statement5.setDouble(2, amount);
            statement5.executeUpdate();
            result = "oke";

            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
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

    public String paymenWithoutSavingAccount(int loan_number, Double amount) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        Float loanAmount = null;
        String result = null;

        try {

            connection = getConnection();
            connection.setAutoCommit(false);
            String sql2 = "select loan_amount from loan where loan_number = ? ";
            statement2 = connection.prepareStatement(sql2);
            statement2.setInt(1, loan_number);
            resultSet = statement2.executeQuery();

            while (resultSet.next()) {
                loanAmount = resultSet.getFloat("loan_amount");
            }

            if (loanAmount - amount < 0) {
                return "justneedtopayenough";
            }
            if (loanAmount == null) {
                return null;
            }

            //plus in current account
            String sql4 = "update loan set loan_amount = ? where loan_number = ?";
            PreparedStatement statement4 = connection.prepareStatement(sql4);
            statement4.setDouble(1, loanAmount - amount);
            statement4.setInt(2, loan_number);
            statement4.executeUpdate();

            String sql5 = "INSERT INTO payment (loan_number, payment_date, amount) VALUES (?, CURRENT_TIMESTAMP, ?)";
            PreparedStatement statement5 = connection.prepareStatement(sql5);
            statement5.setInt(1, loan_number);
            statement5.setDouble(2, amount);
            statement5.executeUpdate();

            result = "oke";

            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
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
