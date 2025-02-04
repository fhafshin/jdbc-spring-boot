package ir.mobin.jdbc.dao;

import ir.mobin.jdbc.entity.Employee;
import ir.mobin.jdbc.mapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private NamedParameterJdbcTemplate template;
    public EmployeeDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    @Override
    public List<Employee> findAll() {
        return template.query("select * from employee",new EmployeeRowMapper());
    }
}
