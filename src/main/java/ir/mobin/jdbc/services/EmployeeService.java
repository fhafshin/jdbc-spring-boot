package ir.mobin.jdbc.services;

import ir.mobin.jdbc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
