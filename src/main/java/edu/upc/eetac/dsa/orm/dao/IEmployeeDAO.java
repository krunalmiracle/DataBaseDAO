package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.orm.model.Employee;

import java.util.List;

public interface IEmployeeDAO {

    int addEmployee(String name, String surname, double salary);
    Employee getEmployee(String employeeID);
    void updateEmployee(String employeeID, String name, String surname, double salary);
    void deleteEmployee(String employeeID);
    List<Employee> getEmployees();
    List <Employee> getEmployeeByDept(String deptId);
}
