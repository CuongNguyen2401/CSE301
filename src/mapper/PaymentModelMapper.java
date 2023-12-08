package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.PaymentModel;

public class PaymentModelMapper implements RowMapper<PaymentModel> {

    @Override
    public PaymentModel mapRow(ResultSet rs) {
        try {
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setLoanPaymentNumber(rs.getInt("loan_payment_number"));
            paymentModel.setLoanNumber(rs.getInt("loan_number"));
            paymentModel.setPaymentDate(rs.getDate("payment_date"));
            paymentModel.setAmount(rs.getFloat("amount"));
            return paymentModel;
        } catch (SQLException ex) {
            System.out.println("Error mapping PaymentModel: " + ex.getMessage());
            return null;
        }
    }
}
