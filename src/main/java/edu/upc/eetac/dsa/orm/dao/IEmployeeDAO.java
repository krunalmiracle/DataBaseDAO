package edu.upc.eetac.dsa.orm.dao;

import edu.upc.eetac.dsa.models.Employee;

import java.util.List;

public interface IEmployeeDAO {

    int addEmployee(String name, String surname, double salary);
    Employee getEmployee(int employeeID);
    void updateEmployee(int employeeID, String name, String surname, double salary);
    void deleteEmployee(int employeeID);
    List<Employee> getEmployees();
    List <Employee> getEmployeeByDept(int deptId);
}
