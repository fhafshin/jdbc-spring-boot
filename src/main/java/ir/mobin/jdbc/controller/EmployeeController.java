package ir.mobin.jdbc.controller;

import ir.mobin.jdbc.dao.EmployeeDao;
import ir.mobin.jdbc.entity.Employee;
import ir.mobin.jdbc.services.EmployeeService;
import ir.mobin.jdbc.services.EmployeeServiceImpl;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final ServerProperties serverProperties;
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService, ServerProperties serverProperties) {
        this.employeeService = employeeService;
        this.serverProperties = serverProperties;
    }
    @GetMapping()
    public List<Employee> getEmployee(){


        return  employeeService.findAll();
    }

    @PostMapping("/create")
    public int createEmployee(@RequestBody Employee employee){;
       return employeeService.insertEmployee(employee);
    }

    @GetMapping("/delete/{id}")
public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);

    }
}
