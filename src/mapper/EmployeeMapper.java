/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.sql.ResultSet;
import model.EmployeeModel;

/**
 *
 * @author TAN
 */
public class EmployeeMapper implements RowMapper<EmployeeModel> {

    @Override
    public EmployeeModel mapRow(ResultSet rs) {
        EmployeeModel employee = new EmployeeModel();
        try {
           
            employee.setSalary(rs.getDouble("salary"));
            employee.setJoining_date(rs.getDate("joining_date"));
            employee.setManager_id(rs.getInt("manager_id"));
            employee.setCustomer_id(rs.getInt("customer_id"));
            employee.setSsn(rs.getString("ssn"));
            employee.setName(rs.getString("name"));
            employee.setDob(rs.getDate("dob"));
            employee.setStreet(rs.getString("street"));
            employee.setCity(rs.getString("city"));
            employee.setProvince(rs.getString("province"));
            employee.setEmployee_id(rs.getString("employee_id"));

        } catch (Exception e) {
            
        }
        return employee;
    }

}
