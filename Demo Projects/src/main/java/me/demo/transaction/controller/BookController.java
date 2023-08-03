package me.demo.transaction.controller;

import lombok.RequiredArgsConstructor;
import me.demo.transaction.dto.BookDTO;
import me.demo.transaction.entity.Book;
import me.demo.transaction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Book> createUser(@RequestBody BookDTO dto){
        return ResponseEntity.ok(bookService.create(dto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/deleteAll")
    public ResponseEntity<?>deleteAll(){
        bookService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<List<Book>>test(@RequestBody BookDTO dto){
        return ResponseEntity.ok(bookService.test(dto));
    }

}
