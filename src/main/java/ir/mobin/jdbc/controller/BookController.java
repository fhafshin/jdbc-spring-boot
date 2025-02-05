package ir.mobin.jdbc.controller;

import ir.mobin.jdbc.entity.Book;
import ir.mobin.jdbc.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
private BookService bookService;
public BookController(BookService bookService) {
    this.bookService = bookService;
}

@GetMapping()
List<Book> findAll(){
    return bookService.findAll();
}

}
