package ir.mobin.jdbc.services;

import ir.mobin.jdbc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    int insertEmployee(Employee employee);

    String updateEmployee(Employee employee);

    String deleteEmployee(int employee);
}
