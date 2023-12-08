package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.LoanModel;

public class LoanMapper implements RowMapper<LoanModel> {

    @Override
    public LoanModel mapRow(ResultSet rs) {
        LoanModel loanModel = new LoanModel();

        try {
            loanModel.setLoanNumber(rs.getInt("loan_number"));
            loanModel.setLoanAmount(rs.getFloat("loan_amount"));
            loanModel.setBranch_id(rs.getInt("branch_id"));

        } catch (SQLException ex) {
            System.out.println("Error mapping LoanModel: " + ex.getMessage());

        }
        return loanModel;
    }
}
