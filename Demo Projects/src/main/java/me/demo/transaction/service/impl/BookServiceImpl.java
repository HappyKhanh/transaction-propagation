package me.demo.transaction.service.impl;

import me.demo.transaction.dto.BookDTO;
import me.demo.transaction.entity.Book;
import me.demo.transaction.repository.BookRepository;
import me.demo.transaction.service.BookService;
import me.demo.transaction.service.mapper.BookMapper;
import me.demo.transaction.util.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    static long i;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookUtils bookUtils;

    @Override
    @Transactional
    public Book create(BookDTO dto) {
        Book entity = bookMapper.toEntity(dto);
        return bookRepository.save(bookMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteAll() {
        bookRepository.deleteAll();

    }

    @Override
    @Transactional
    public List<Book> test(BookDTO dto) {
        // Bên ngoài controller không được đánh transactional, nên sẽ không thuộc context transaction nào
        // Đi vào service sẽ xuất hiện context do được đánh transactional
        this.testSameBean();
        // REQUIRED NEW
        // Nếu cùng bean:

        // Method được đánh Require new sẽ nằm trong một context transaction riêng biệt
        bookRepository.saveAnyway(bookMapper.toEntity(dto));

        Book book = new Book();

        i = i+1;
        book.setName("test lần " +i);
        book.setPrice(999);

        // Method không được đánh transaction sẽ được chia sẻ context
        String uuid = bookUtils.genUUid();

        // Method không được đánh transaction Never sẽ ném ra exception nếu được gọi trong transaction
        if(dto.getId() != null){  bookUtils.neverTrans(); }

        book.setAuthor("Khánh "+ uuid);

        Book savedBook = bookRepository.save(book);

        // Gặp exception thì sẽ không lưu xuống db
        if(savedBook != null){
            throw new IllegalArgumentException("Exception");
        }

        return bookRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testSameBean(){
        System.out.println("Same shit");
    }


}
