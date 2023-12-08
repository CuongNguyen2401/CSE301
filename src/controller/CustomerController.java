package controller;

import dao.impl.CurrentAccountDAO;
import dao.impl.CustomerDAO;
import dao.impl.LoanDao;
import dao.impl.PaymentDAO;
import dao.impl.SavingAccountDAO;
import java.util.List;
import model.CurrentAccountModel;
import model.CustomerModel;
import model.LoanModel;
import model.PersonPhoneModel;
import model.SavingAccountModel;

/**
 *
 * @author ACER
 */
public class CustomerController {

    private CustomerModel customerModel;
    private CustomerDAO customerDao = new CustomerDAO();
    private LoanDao loanDao = new LoanDao();
    private CurrentAccountDAO currentAccountDAO = new CurrentAccountDAO();
    private SavingAccountDAO savingAccountDAO = new SavingAccountDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();

    public CustomerController(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public void updateInformationCustomer(CustomerModel customer) {
        customerDao.update(customerModel);
    }

    public void doCustomSQL(String a) {
        customerDao.customsql(a);
    }

    public void saveCurrentAccount(CurrentAccountModel currentAccountModel, String id) {
        currentAccountDAO.saveCurrentAcount(currentAccountModel, id);
    }

    public List<CurrentAccountModel> findAllCurrentAccount(String customer_id) {
        return currentAccountDAO.findAllCurrentAccount(customer_id);

    }

    public List<String> selectBranch() {
        return customerDao.selectBranchCities();
    }

    public void savePhone(PersonPhoneModel personPhoneModel) {
        customerDao.save(personPhoneModel);
    }

    public List<PersonPhoneModel> showAllPhone(String a) {
        return customerDao.selectAllPhoneBySsn(a);
    }

    public List<SavingAccountModel> findAllSavingAccount(String customer_id) {
        return savingAccountDAO.findAllSavingAccount(customer_id);
    }

    public void saveSavingAccount(SavingAccountModel savingAccountModel, String id) {
        savingAccountDAO.saveSavingAcount(savingAccountModel, id);
    }

    public int findBranchIDByCity(String branch_id) {
        return currentAccountDAO.selectBranchIDByCurrentAccount(branch_id);
    }

    public String findBranchCiTyByID(int branch_id) {
        return currentAccountDAO.selectBranchCityByCurrentAccount(branch_id);
    }

    public String transferMoney(String savingsAccount, String currentAccount, Double amount) {
        return savingAccountDAO.transferMoney(savingsAccount, currentAccount, amount);
    }

    public void updateLastTimeTransfer(String a, String b) {
        savingAccountDAO.updateSavingTime(a, b);
    }

    public List<LoanModel> findAllLoan(String a) {
        return loanDao.SelectAllLoanModel(a);
    }

    public Long saveLoan(LoanModel loanModel, String a) {
        return loanDao.save(loanModel, a);
    }

    public String paymenWithSavingAccount(String account_number, int loanNumber, Double amount) {
        return paymentDAO.paymenWithSavingAccount(account_number, loanNumber, amount);
    }

    public String paymenWithoutSavingAccount(int loanNumber, Double amount) {
        return paymentDAO.paymenWithoutSavingAccount(loanNumber, amount);
    }

}
