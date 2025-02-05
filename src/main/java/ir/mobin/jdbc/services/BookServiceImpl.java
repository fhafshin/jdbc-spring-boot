package ir.mobin.jdbc.services;

import ir.mobin.jdbc.dao.BookDao;
import ir.mobin.jdbc.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    private BookDao bookDao;
   public BookServiceImpl(BookDao bookDao) {

        this.bookDao = bookDao;
    }
    @Override
    public List<Book> findAll() {
        return bookDao.finAll();
    }
}
