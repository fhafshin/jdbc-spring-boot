package ir.mobin.jdbc.controller;

import ir.mobin.jdbc.dao.EmployeeDao;
import ir.mobin.jdbc.entity.Employee;
import ir.mobin.jdbc.services.EmployeeService;
import ir.mobin.jdbc.services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping()
    public List<Employee> getEmployee(){


        return  employeeService.findAll();
    }

}
