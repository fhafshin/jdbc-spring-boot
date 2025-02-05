package ir.mobin.jdbc.dao;

import ir.mobin.jdbc.entity.Book;
import ir.mobin.jdbc.mapper.BookRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookDaoImpl implements BookDao{

    private NamedParameterJdbcTemplate template;
    public BookDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    @Override
    public List<Book> finAll() {
        return template.query("select * from book",new BookRowMapper());
    }
}
