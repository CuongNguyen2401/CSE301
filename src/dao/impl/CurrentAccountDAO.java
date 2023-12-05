package dao.impl;

import dao.ICurrentAccountDAO;
import java.util.Date;
import model.CurrentAccountModel;

/**
 *
 * @author ACER
 */
public class CurrentAccountDAO extends AbstractDAO<CurrentAccountModel> implements ICurrentAccountDAO {

    @Override
    public String savingCurrentAcount(CurrentAccountModel currentAccountModel, String interestRate, String id) {
        String sql = "INSERT INTO current_account (account_number, balance, branch_id, overdrafts)"
                + "VALUES (?, ?, ?, ?)";
        insert(sql, currentAccountModel.getAccountNumber(), currentAccountModel.getBalance(), currentAccountModel.getBranchID(), currentAccountModel.getOverdrafts());

        String sql2 = "NSERT INTO current_account_customer (account_number, customer_id, last_access_date)"
                + "VALUES (?, ?, ?)";
        Date currentDate = new Date();
        insert(sql2, currentAccountModel.getAccountNumber(), id, new java.sql.Date(currentDate.getTime()));
        
        return currentAccountModel.getAccountNumber();
    }

}
