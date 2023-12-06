package model;

/**
 *
 * @author ACER
 */
public class EmployeeDependentsModel {

    private String employeeId;
    private String dependents;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDependents() {
        return dependents;
    }

    public void setDependents(String dependents) {
        this.dependents = dependents;
    }

    @Override
    public String toString() {
        return "EmployeeDependentsModel{" + "employeeId=" + employeeId + ", dependents=" + dependents + '}';
    }

}
