package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.CurrentAccountModel;

public class CurrentAccountMapper implements RowMapper<CurrentAccountModel> {

    @Override
    public CurrentAccountModel mapRow(ResultSet rs) {
        CurrentAccountModel currentAccount = new CurrentAccountModel();

        try {
            currentAccount.setAccountNumber(rs.getString("account_number"));
            currentAccount.setBalance(rs.getDouble("balance"));
            currentAccount.setBranchID(rs.getInt("branch_id"));
            currentAccount.setOverdrafts(rs.getDouble("overdrafts"));
        } catch (SQLException ex) {
            System.out.println("Set failed!" + ex);
        }
        return currentAccount;
    }
}
