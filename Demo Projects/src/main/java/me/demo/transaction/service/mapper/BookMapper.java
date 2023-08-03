package me.demo.transaction.service.mapper;

import me.demo.transaction.dto.BookDTO;
import me.demo.transaction.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book entity);

    Book toEntity(BookDTO dto);

}
