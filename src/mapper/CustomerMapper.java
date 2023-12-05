package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.CustomerModel;

/**
 *
 * @author ACER
 */
public class CustomerMapper implements RowMapper<CustomerModel> {

    @Override
    public CustomerModel mapRow(ResultSet rs) {
        CustomerModel customer = new CustomerModel();

        try {
            customer.setCustomer_id(rs.getString("customer_id"));
            customer.setCredit_rating(rs.getFloat("credit_rating"));
            customer.setSsn(rs.getString("ssn"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getDate("dob"));
            customer.setStreet(rs.getString("street"));
            customer.setCity(rs.getString("city"));
            customer.setProvince(rs.getString("province"));

        } catch (SQLException ex) {
            System.out.println("Set failed!" + ex);
        }
        return customer;

    }

}
