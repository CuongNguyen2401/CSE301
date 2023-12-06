package dao.impl;

import dao.ICustomerDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.CustomerMapper;
import model.CustomerModel;

/**
 *
 * @author ACER
 */
public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDao {

    @Override
    public CustomerModel findByCustomerID(String customer_id) {

        String sql = "SELECT * FROM customer where customer_id = ?";

        List<CustomerModel> models = query(sql, new CustomerMapper(), customer_id);

        return models.isEmpty() ? null : models.get(0);
    }

    @Override
    public Long save(CustomerModel customer) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO customer (customer_id, credit_rating, ssn, name, dob, street, city, province) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
        Long generatedId = insert(sql.toString(), customer.getCustomer_id(), customer.getCredit_rating(), customer.getSsn(), customer.getName(), customer.getDob(), customer.getStreet(), customer.getCity(), customer.getProvince());

        return generatedId;
    }

    @Override
    public List<CustomerModel> findAllCustomer() {
        String sql = "SELECT * FROM customer";
        return query(sql, new CustomerMapper());
    }

    @Override
    public String findLastCustomerID() {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT * FROM customer ORDER BY customer_id DESC LIMIT ? ");

        List<CustomerModel> models = query(sql.toString(), new CustomerMapper(), 1);

        return models.isEmpty() ? null : models.get(0).getCustomer_id();
    }

    @Override
    public void update(CustomerModel customer) {
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE customer SET credit_rating = ?, ssn = ?, name = ?, dob = ?, street = ?, city = ?, province = ? WHERE customer_id = ?");

        try {
            update(sql.toString(), customer.getCredit_rating(), customer.getSsn(), customer.getName(), customer.getDob(),
                    customer.getStreet(), customer.getCity(), customer.getProvince(), customer.getCustomer_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<String> selectBranchCities() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> branchCities = new ArrayList<>();

        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            String sql = "SELECT branch_city FROM branch";

            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String branchCity = resultSet.getString("branch_city");
                branchCities.add(branchCity);
            }

            connection.commit();

            return branchCities;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);

            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public java.sql.Connection getConnection() {
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
}
