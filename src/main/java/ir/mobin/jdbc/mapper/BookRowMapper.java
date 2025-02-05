package ir.mobin.jdbc.mapper;

import ir.mobin.jdbc.entity.Book;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
       Book book = new Book();
       book.setTitle(rs.getString("title"));
       book.setAuthor(rs.getString("author"));
       return book;
    }
}
