package controller;

import dao.impl.CurrentAccountDAO;
import dao.impl.CustomerDAO;
import java.util.List;
import model.CurrentAccountModel;
import model.CustomerModel;

/**
 *
 * @author ACER
 */
public class CustomerController {

    private CustomerModel customerModel;
    private CustomerDAO customerDao = new CustomerDAO();
    private CurrentAccountDAO currentAccountDAO = new CurrentAccountDAO();
    private CurrentAccountModel currentAccountModel;

    public CustomerController(CustomerModel customerModel, CurrentAccountModel currentAccountModel) {
        this.customerModel = customerModel;
        this.currentAccountModel = currentAccountModel;
    }

    public void updateInformationCustomer(CustomerModel customer) {
        customerDao.update(customerModel);
    }

    public void saveCurrentAccount(CurrentAccountModel currentAccountModel, String id) {
        currentAccountDAO.saveCurrentAcount(currentAccountModel, customerModel.getCustomer_id());
    }

    public List<String> selectBranch() {
        return customerDao.selectBranchCities();
    }

}
