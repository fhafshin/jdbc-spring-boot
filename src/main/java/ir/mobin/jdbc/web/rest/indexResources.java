package ir.mobin.jdbc.web.rest;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexResources {

    private final JdbcTemplate jdbcTemplate;


    public indexResources(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    String helloWorld() {


        var result=jdbcTemplate.queryForList("select count(*) from codes");

        return new StringBuilder().append(result.stream().count()).toString();
    }


}
