package br.com.erudio.unitTests.mapper;

import br.com.erudio.dto.v1.PersonDTOv1;
import br.com.erudio.dto.v1.BookDTOv1;
import br.com.erudio.mapper.ModelMapper;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;
import br.com.erudio.unitTests.mapper.mocks.MockBook;
import br.com.erudio.unitTests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookConverterTest {
    
    MockBook inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookDTOv1 output = ModelMapper.parseObject(inputObject.mockEntity(), BookDTOv1.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("Author Test1", output.getAuthor());
        assertEquals(Date.from(Instant.now()), output.getLaunchDate());
        assertEquals(Double.valueOf(0), output.getPrice());
        assertEquals("Title Test", output.getTitle());

    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookDTOv1> outputList = ModelMapper.parseListObjects(inputObject.mockEntityList(), BookDTOv1.class);
        BookDTOv1 outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("Author Test1", outputZero.getAuthor());
        assertEquals(Date.from(Instant.now()), outputZero.getLaunchDate());
        assertEquals(Double.valueOf(0), outputZero.getPrice());
        assertEquals("Title Test", outputZero.getTitle());

        BookDTOv1 outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("Author Test1", outputSeven.getAuthor());
        assertEquals(Date.from(Instant.now()), outputSeven.getLaunchDate());
        assertEquals(Double.valueOf(7), outputSeven.getPrice());
        assertEquals("Title Test", outputSeven.getTitle());

        BookDTOv1 outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("Author Test1", outputTwelve.getAuthor());
        assertEquals(Date.from(Instant.now()), outputTwelve.getLaunchDate());
        assertEquals(Double.valueOf(12), outputTwelve.getPrice());
        assertEquals("Title Test", outputTwelve.getTitle());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = ModelMapper.parseObject(inputObject.mockDTO(), Book.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Author Test1", output.getAuthor());
        assertEquals(Date.from(Instant.now()), output.getLaunchDate());
        assertEquals(Double.valueOf(0), output.getPrice());
        assertEquals("Title Test", output.getTitle());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = ModelMapper.parseListObjects(inputObject.mockDTOList(), Book.class);
        Book outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Author Test1", outputZero.getAuthor());
        assertEquals(Date.from(Instant.now()), outputZero.getLaunchDate());
        assertEquals(Double.valueOf(0), outputZero.getPrice());
        assertEquals("Title Test", outputZero.getTitle());

        Book outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Author Test1", outputSeven.getAuthor());
        assertEquals(Date.from(Instant.now()), outputSeven.getLaunchDate());
        assertEquals(Double.valueOf(7), outputSeven.getPrice());
        assertEquals("Title Test", outputSeven.getTitle());

        Book outputTwelve = outputList.get(12);


        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Author Test1", outputTwelve.getAuthor());
        assertEquals(Date.from(Instant.now()), outputTwelve.getLaunchDate());
        assertEquals(Double.valueOf(12), outputTwelve.getPrice());
        assertEquals("Title Test", outputTwelve.getTitle());
    }
}
