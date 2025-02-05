package ir.mobin.jdbc.services;

import ir.mobin.jdbc.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
}
