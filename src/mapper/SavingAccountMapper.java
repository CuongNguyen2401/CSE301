package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SavingAccountModel;

/**
 *
 * @author ACER
 */
public class SavingAccountMapper implements RowMapper<SavingAccountModel> {

    @Override
    public SavingAccountModel mapRow(ResultSet rs) {
        SavingAccountModel savingAccountModel = new SavingAccountModel();
        try {
            savingAccountModel.setAccountNumber(rs.getString("account_number"));
            savingAccountModel.setBalance(rs.getDouble("balance"));
            savingAccountModel.setBranchID(rs.getInt("branch_id"));
            savingAccountModel.setInterestRate(rs.getDouble("interest_rate"));
            // Set other properties as needed

        } catch (SQLException ex) {
            Logger.getLogger(SavingAccountMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return savingAccountModel;
    }
    
}
