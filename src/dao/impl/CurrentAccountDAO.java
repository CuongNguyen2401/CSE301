package dao.impl;

import dao.ICurrentAccountDAO;
import java.util.Date;
import java.util.List;
import mapper.BranchMapper;
import mapper.CurrentAccountMapper;
import model.BranchModel;
import model.CurrentAccountModel;

/**
 *
 * @author ACER
 */
public class CurrentAccountDAO extends AbstractDAO<CurrentAccountModel> implements ICurrentAccountDAO {

    @Override
    public String saveCurrentAcount(CurrentAccountModel currentAccountModel, String id) {
        String lastAccountNumber = findLastCurrentAccountModelByID();

        long newAccountNumber = Long.parseLong(lastAccountNumber) + 1;
        currentAccountModel.setAccountNumber(String.valueOf(newAccountNumber));

        String sql = "INSERT INTO current_account (account_number, balance, branch_id, overdrafts)"
                + "VALUES (?, ?, ?, ?)";
        insert(sql, currentAccountModel.getAccountNumber(), currentAccountModel.getBalance(), currentAccountModel.getBranchID(), currentAccountModel.getOverdrafts());

        String sql2 = "INSERT INTO current_account_customer (account_number, customer_id, last_access_date)"
                + "VALUES (?, ?, ?)";
        Date currentDate = new Date();

        insert(sql2, currentAccountModel.getAccountNumber(), id, new java.sql.Timestamp(currentDate.getTime()));
        return currentAccountModel.getAccountNumber();
    }

    public String findLastCurrentAccountModelByID() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM current_account ORDER BY account_number DESC LIMIT 1");

        List<CurrentAccountModel> models = query(sql.toString(), new CurrentAccountMapper());

        if (models != null && !models.isEmpty()) {
            return models.get(0).getAccountNumber();
        } else {
            System.out.println("No first account");
            return "3000000000";
        }
    }

    @Override
    public List<CurrentAccountModel> findAllCurrentAccount(String customer_id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM current_account JOIN current_account_customer ON current_account.account_number = current_account_customer.account_number WHERE customer_id = ?;");
        return query(sql.toString(), new CurrentAccountMapper(), customer_id);
    }

    @Override
    public CurrentAccountModel findCurrentAccountModelByID(String id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM current_account where account_number = ?");
        List<CurrentAccountModel> models = query(sql.toString(), new CurrentAccountMapper(), id);
        return models.isEmpty() ? null : models.get(0);
    }
// comment here
    public int selectBranchIDByCurrentAccount(String branch) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT* FROM branch where branch_city = ? ");
        List<BranchModel> models =  query(sql.toString(), new BranchMapper(), branch);
        
       return models.isEmpty() ? null : models.get(0).getBranchId();
    }
      public String selectBranchCityByCurrentAccount(int branch_id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT* FROM branch where branch_id= ? ");
        List<BranchModel> models =  query(sql.toString(), new BranchMapper(), branch_id);
        
       return models.isEmpty() ? null : models.get(0).getBranchCity();
    }

}
