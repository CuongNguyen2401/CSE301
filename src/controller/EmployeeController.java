package controller;

import dao.impl.CustomerDAO;
import dao.impl.EmployeeDAO;
import model.CustomerModel;
import model.EmployeeModel;

/**
 *
 * @author ACER
 */
public class EmployeeController {

    private EmployeeModel employeeModel;
    private CustomerModel customerModel;
    private EmployeeDAO empDao = new EmployeeDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    

    public EmployeeController(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

}
