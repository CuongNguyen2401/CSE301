package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import mapper.SavingAccountMapper;
import model.SavingAccountModel;

/**
 *
 * @author ACER
 */
public class SavingAccountDAO extends AbstractDAO<SavingAccountModel> {

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

    public String saveSavingAcount(SavingAccountModel savingAccountModel, String id) {
        String lastAccountNumber = findLastSavingAccountModelByID();

        long newAccountNumber = Long.parseLong(lastAccountNumber) + 1;
        savingAccountModel.setAccountNumber(String.valueOf(newAccountNumber));

        String sql = "INSERT INTO  savings_account (account_number, balance, branch_id, interest_rate)"
                + "VALUES (?, ?, ?, ?)";
        insert(sql, savingAccountModel.getAccountNumber(), savingAccountModel.getBalance(), savingAccountModel.getBranchID(), savingAccountModel.getInterestRate());

        String sql2 = "INSERT INTO savings_account_customer (account_number, customer_id, last_access_date)"
                + "VALUES (?, ?, ?)";
        Date currentDate = new Date();

        insert(sql2, savingAccountModel.getAccountNumber(), id, new java.sql.Timestamp(currentDate.getTime()));
        return savingAccountModel.getAccountNumber();
    }

    public String findLastSavingAccountModelByID() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM  savings_account ORDER BY account_number DESC LIMIT 1");

        List<SavingAccountModel> models = query(sql.toString(), new SavingAccountMapper());

        if (models != null && !models.isEmpty()) {
            return models.get(0).getAccountNumber();
        } else {
            System.out.println("No first account");
            return "4000000000";
        }
    }

    public List<SavingAccountModel> findAllSavingAccount(String customer_id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM savings_account JOIN savings_account_customer ON savings_account.account_number = savings_account_customer.account_number WHERE customer_id = ?;");
        return query(sql.toString(), new SavingAccountMapper(), customer_id);
    }

    public SavingAccountModel findSavingAccountModelByID(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM savings_account where account_number = ?");
        List<SavingAccountModel> models = query(sql.toString(), new SavingAccountMapper(), id);
        return models.isEmpty() ? null : models.get(0);
    }

    public String transferMoney(String savingsAccount, String currentAccount, Double amount) {
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        ResultSet resultSet = null;
        Double savingAmount = null;
        Double currentAmount = null;
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
            if (savingAmount <= 200.0) {
                return "1";
            }
            if (savingAmount - amount <= 50.0) {
                return "2";
            }

            String sql2 = "select balance from current_account where account_number = ? ";
            statement2 = connection.prepareStatement(sql2);
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

    public void updateSavingTime(String customer_id, String account_number) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE savings_account_customer ");
        sql.append("SET last_access_date = CURRENT_TIMESTAMP ");
        sql.append("WHERE customer_id = ? AND account_number = ?;");

         update(sql.toString(), customer_id, account_number);
    }
}
