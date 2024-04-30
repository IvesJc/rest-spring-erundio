package br.com.erudio.unitTests.mapper.mocks;

import br.com.erudio.dto.v1.BookDTOv1;
import br.com.erudio.model.Book;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Book mockEntity(){
        return mockEntity(0);
    }
    public BookDTOv1 mockDTO(){
        return mockDTO(0);
    }

    public List<Book> mockEntityList(){
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 14; i++){
            books.add(mockEntity(i));
        }
        return books;
    }
    public List<BookDTOv1> mockDTOList(){
        List<BookDTOv1> booksDTO = new ArrayList<>();
        for (int i = 0; i < 14; i++){
            booksDTO.add(mockDTO(i));
        }
        return booksDTO;
    }

    public Book mockEntity(Integer num){
        Book book = new Book();
        book.setId(num.longValue());
        book.setAuthor("Author Test" +num);
        book.setLaunchDate(Date.from(Instant.now()));
        book.setPrice(Double.valueOf(num));
        book.setTitle("Title Test" +num);
        return book;
    }

    public BookDTOv1 mockDTO(Integer num){
        return new BookDTOv1(
                num.longValue(),
                "Author Test" +num,
                Date.from(Instant.now()),
                Double.valueOf(num),
                "Title Test" +num);
    }
}
