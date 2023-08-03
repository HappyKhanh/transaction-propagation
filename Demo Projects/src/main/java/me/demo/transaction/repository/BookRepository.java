package me.demo.transaction.repository;

import me.demo.transaction.dto.BookDTO;
import me.demo.transaction.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    default Book saveAnyway(Book entity){
        return save(entity);
    }

}
