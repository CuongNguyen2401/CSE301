package controller;

import dao.impl.CustomerDAO;
import dao.impl.EmployeeDAO;
import model.CustomerModel;
import model.EmployeeModel;

/**
 *
 * @author ACER
 */
public class LoginController {

    private CustomerDAO customerDao;
    private EmployeeDAO employeeDao;

    public LoginController(CustomerDAO customerDao, EmployeeDAO employeeDao) {
        this.customerDao = customerDao;
        this.employeeDao = employeeDao;
    }

    public Long save(CustomerModel customerModel) {
        return customerDao.save(customerModel);
    }

    public Object login(String username, String password) {
        Object model = null;

        if (username.startsWith("Emp")) {
            EmployeeModel employeeModel = employeeDao.findByEmployeeId(username);
            if (employeeModel != null && employeeModel.getDob().toString().equals(password)) {
                // Successfully logged in as an employee
                model = employeeModel;
            }
        } else if (username.startsWith("Cust")) {
            CustomerModel customerModel = customerDao.findByCustomerID(username);
            if (customerModel != null && customerModel.getDob().toString().equals(password)) {
                // Successfully logged in as a customer
                model = customerModel;
            }
        }

        return model;
    }

    public String findLastCustomerById() {
        return customerDao.findLastCustomerID();
    }


}
