package ir.mobin.jdbc.services;

import ir.mobin.jdbc.dao.EmployeeDao;
import ir.mobin.jdbc.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;
    public  EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public int insertEmployee(Employee employee) {
       return employeeDao.insertEmployee(employee);
    }

    @Override
    public String updateEmployee(Employee employee) {

                employeeDao.updateEmployee(employee);
                return "updated";
    }

    @Override
    public String deleteEmployee(int employee) {
        employeeDao.deleteEmployee(employee);
        return "deleted";
    }
}
