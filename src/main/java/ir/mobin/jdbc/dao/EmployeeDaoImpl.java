package ir.mobin.jdbc.dao;

import ir.mobin.jdbc.entity.Employee;
import ir.mobin.jdbc.mapper.EmployeeRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private NamedParameterJdbcTemplate template;

    public EmployeeDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Employee> findAll() {
        return template.query("select * from employee", new EmployeeRowMapper());
    }

    @Override
    public int insertEmployee(Employee employee) {
        System.out.println(employee.getFirstName());
        String sql = "insert into employee(first_name,last_name) values(:first_name,:last_name)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("first_name", employee.getFirstName())
                .addValue("last_name", employee.getLastName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, param, keyHolder);
        return Integer.parseInt(keyHolder.getKeys().get("id").toString());
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee set first_name=:first_name,last_name=:last_name where id=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("first_name", employee.getFirstName());
        map.put("last_name", employee.getLastName());
        map.put("id", employee.getId());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sql = "delete from employee where id=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", employeeId);

        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });

    }
}
