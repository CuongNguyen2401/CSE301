package dao.impl;

import dao.ICurrentAccountDAO;
import java.util.Date;
import java.util.List;
import mapper.CurrentAccountMapper;
import model.CurrentAccountModel;

/**
 *
 * @author ACER
 */
public class CurrentAccountDAO extends AbstractDAO<CurrentAccountModel> implements ICurrentAccountDAO {

    @Override
    public String saveCurrentAcount(CurrentAccountModel currentAccountModel, String id) {
        String sql = "INSERT INTO current_account (account_number, balance, branch_id, overdrafts)"
                + "VALUES (?, ?, ?, ?)";
        insert(sql, currentAccountModel.getAccountNumber(), currentAccountModel.getBalance(), currentAccountModel.getBranchID(), currentAccountModel.getOverdrafts());

        String sql2 = "NSERT INTO current_account_customer (account_number, customer_id, last_access_date)"
                + "VALUES (?, ?, ?)";
        Date currentDate = new Date();
        insert(sql2, currentAccountModel.getAccountNumber(), id, new java.sql.Date(currentDate.getTime()));

        return currentAccountModel.getAccountNumber();
    }

    @Override
    public List<CurrentAccountModel> findAllcurrentAccount() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM current_account");
        return query(sql.toString(), new CurrentAccountMapper());
    }

    @Override
    public CurrentAccountModel findCurrentAccountModelByID(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM current_account where account_number = ?");
        List<CurrentAccountModel> models = query(sql.toString(), new CurrentAccountMapper(), id);
        return models.isEmpty() ? null : models.get(0);
    }

}
