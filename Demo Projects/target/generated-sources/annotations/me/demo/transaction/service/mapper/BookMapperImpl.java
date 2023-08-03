package me.demo.transaction.service.mapper;

import javax.annotation.Generated;
import me.demo.transaction.dto.BookDTO;
import me.demo.transaction.entity.Book;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-01T13:40:13+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.19 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDTO(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( entity.getId() );
        bookDTO.setName( entity.getName() );
        bookDTO.setAuthor( entity.getAuthor() );
        bookDTO.setPrice( entity.getPrice() );

        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( dto.getId() );
        book.setName( dto.getName() );
        book.setPrice( dto.getPrice() );
        book.setAuthor( dto.getAuthor() );

        return book;
    }
}
