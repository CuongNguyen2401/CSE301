package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.CustomerLoanModel;

/**
 *
 * @author ACER
 */
public class CustomerLoanMapper implements RowMapper<CustomerLoanModel> {
    
    CustomerLoanModel customerLoanModel = new CustomerLoanModel();
    
    @Override
    public CustomerLoanModel mapRow(ResultSet rs) {
        try {
            customerLoanModel.setCustomerId(rs.getString("customer_id"));
            customerLoanModel.setLoanNumber(rs.getInt("loan_number"));
        } catch (SQLException ex) {
            System.out.println("Set failed!" + ex);
        }
        return customerLoanModel;
    }
}
