package br.com.erudio.unitTests.services;

import br.com.erudio.dto.v1.BookDTOv1;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.services.BookService;
import br.com.erudio.unitTests.mapper.mocks.MockBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    MockBook mockBook;

    private final Date mockDate = Date.from(Instant.parse("2010-12-03T10:15:30.00Z"));

    @InjectMocks
    private BookService bookService;

    @Mock
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        mockBook = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        List<Book> listBook = mockBook.mockEntityList();

        when(bookRepository.findAll()).thenReturn(listBook);

        List<BookDTOv1> books = bookService.findAll();
        assertNotNull(books);
        assertEquals(14, books.size());

        BookDTOv1 bookOne = books.get(1);
        assertNotNull(bookOne);
        assertNotNull(bookOne.getKey());
        assertNotNull(bookOne.getLinks());
        assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals(mockDate, bookOne.getLaunchDate());
        assertEquals(Double.valueOf(1), bookOne.getPrice());
        assertEquals("Title Test1", bookOne.getTitle());

    }

    @Test
    void findById() {
        Book book = mockBook.mockEntity(1);
        book.setId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        BookDTOv1 bookOne = bookService.findById(1L);
        assertNotNull(bookOne);
        assertNotNull(bookOne.getKey());
        assertNotNull(bookOne.getLinks());
        assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals(mockDate, bookOne.getLaunchDate());
        assertEquals(Double.valueOf(1), bookOne.getPrice());
        assertEquals("Title Test1", bookOne.getTitle());

    }

    @Test
    void create() {
        Book persisted = mockBook.mockEntity(1);
        persisted.setId(1L);

        BookDTOv1 dto = mockBook.mockDTO(1);
        dto.setKey(1L);

        when(bookRepository.save(any(Book.class))).thenReturn(persisted);

        BookDTOv1 bookOne = bookService.create(dto);
        assertNotNull(bookOne);
        assertNotNull(bookOne.getKey());
        assertNotNull(bookOne.getLinks());
        assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals(mockDate, bookOne.getLaunchDate());
        assertEquals(Double.valueOf(1), bookOne.getPrice());
        assertEquals("Title Test1", bookOne.getTitle());


    }

    @Test
    void update() {
        Book book = mockBook.mockEntity(1);
        book.setId(1L);

        Book persisted = mockBook.mockEntity(1);
        persisted.setId(1L);

        BookDTOv1 dto = mockBook.mockDTO(1);
        dto.setKey(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(persisted);


        BookDTOv1 bookOne = bookService.update(dto);
        assertNotNull(bookOne);
        assertNotNull(bookOne.getKey());
        assertNotNull(bookOne.getLinks());
        assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals(mockDate, bookOne.getLaunchDate());
        assertEquals(Double.valueOf(1), bookOne.getPrice());
        assertEquals("Title Test1", bookOne.getTitle());


    }

    @Test
    void delete() {
        Book book = mockBook.mockEntity(1);
        book.setId(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        bookService.delete(1L);
    }
}