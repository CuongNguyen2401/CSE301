/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IEmployeeDAO;
import java.util.List;
import mapper.EmployeeMapper;
import model.EmployeeModel;

/**
 *
 * @author TAN
 */
public class EmployeeDAO extends AbstractDAO<EmployeeModel> implements IEmployeeDAO {

    @Override
    public EmployeeModel findByEmployeeId(String employeeId) {
        String sql = "select * from employee where employee_id = ?";

        List<EmployeeModel> models = query(sql, new EmployeeMapper(), employeeId);

        return models.isEmpty() ? null : models.get(0);
    }

    @Override
    public List<EmployeeModel> findAllEmployee() {
        String sql = "select * from employee";

        List<EmployeeModel> models = query(sql, new EmployeeMapper());
        return query(sql, new EmployeeMapper());
    }

    @Override
    public Long save(EmployeeModel employee) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO employee (employee_id, salary, joining_date, manager_id,  ssn, name, dob, street, city, province) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        System.out.println("Successfull test employee");
        return insert(sql.toString(), employee.getEmployee_id(), employee.getSalary(), employee.getJoining_date(),
                employee.getManager_id(), employee.getSsn(), employee.getName(),
                employee.getDob(), employee.getStreet(), employee.getCity(), employee.getProvince());
    }

}
