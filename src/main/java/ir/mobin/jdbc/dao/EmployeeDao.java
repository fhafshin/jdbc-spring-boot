package ir.mobin.jdbc.dao;

import ir.mobin.jdbc.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    int insertEmployee(Employee employee);

    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);

}
