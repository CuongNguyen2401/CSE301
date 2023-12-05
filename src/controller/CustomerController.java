package controller;

import dao.impl.CurrentAccountDAO;
import dao.impl.CustomerDAO;
import model.CustomerModel;

/**
 *
 * @author ACER
 */
public class CustomerController {

    private CustomerModel customerModel;
    private CustomerDAO customerDao = new CustomerDAO();
    private CurrentAccountDAO currentAccountDAO = new CurrentAccountDAO();

    public CustomerController(CustomerModel customerModel, CurrentAccountDAO currentAccountDAO) {
        this.customerModel = customerModel;
        this.currentAccountDAO = currentAccountDAO;
    }

    public void updateInformationCustomer(CustomerModel customer) {
        customerDao.update(customerModel);
    }

}
