package br.com.erudio.services;

import br.com.erudio.controller.BookController;
import br.com.erudio.dto.v1.BookDTOv1;
import br.com.erudio.exceptions.RequiredObjectIsNullExecption;
import br.com.erudio.exceptions.ResourceNotFoundExecption;
import br.com.erudio.mapper.ModelMapper;
import br.com.erudio.model.Book;
import br.com.erudio.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private Logger logger = Logger.getLogger(BookService.class.getName());

    public List<BookDTOv1> findAll(){
        logger.info("Finding all books!");
        List<BookDTOv1> dtos = ModelMapper.parseListObjects(bookRepository.findAll(), BookDTOv1.class);
        dtos.
            forEach(p -> p.add(linkTo(methodOn(BookController.class).
            findById(p.getKey())).
            withSelfRel()));
        return dtos;
    }


    public BookDTOv1 findById(Long id){
        logger.info("Finding one book!");
        Book entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No " +
                "records found for this ID!"));

        BookDTOv1 dto = ModelMapper.parseObject(entity, BookDTOv1.class);
        dto.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return dto;
    }


    public BookDTOv1 create(BookDTOv1 bookDTOv1){
        // recebe DTO       ^^^^^^^^^^^^^^^^^^^^

        if (bookDTOv1 == null) throw new RequiredObjectIsNullExecption();
        logger.info("Creating one book!");
        Book entity = ModelMapper.parseObject(bookDTOv1, Book.class);
        // converte o DTO para a entidade       ^^^^^^^^^^^^^^^^^^^^^^^
        Book entidade = bookRepository.save(entity);
        BookDTOv1 dto = ModelMapper.parseObject(entidade, BookDTOv1.class);
        //                             ^^^^^^^^^^^^^^^^^^^^^^^^^
        // pra finalizar, converte entidade em DTO
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }
    public BookDTOv1 update(BookDTOv1 bookDTOv1){
        if (bookDTOv1 == null) throw new RequiredObjectIsNullExecption();
        logger.info("Updating one book!");

        Book entity =
                bookRepository.findById(bookDTOv1.getKey()).orElseThrow(() -> new ResourceNotFoundExecption(
                        "No records found for this ID"));
        entity.setAuthor(bookDTOv1.getAuthor());
        entity.setLaunchDate(bookDTOv1.getLaunchDate());
        entity.setPrice(bookDTOv1.getPrice());
        entity.setTitle(bookDTOv1.getTitle());

        BookDTOv1 dto =ModelMapper.parseObject(bookRepository.save(entity), BookDTOv1.class);
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }

    public void delete(Long id){
        logger.info("Deleting one book!");
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No " +
                "records found for this ID"));

        bookRepository.delete(book);
    }

}
