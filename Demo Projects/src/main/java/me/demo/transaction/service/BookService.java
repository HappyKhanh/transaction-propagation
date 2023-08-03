package me.demo.transaction.service;

import me.demo.transaction.dto.BookDTO;
import me.demo.transaction.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    Book create(BookDTO dto);

    List<Book> findAll();

    void deleteAll();

    List<Book> test(BookDTO dto);

}
