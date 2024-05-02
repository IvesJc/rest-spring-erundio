package br.com.erudio.mapper;

import br.com.erudio.dto.v1.BookDTOv1;
import br.com.erudio.dto.v1.PersonDTOv1;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {

    private static org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    static {
        mapper.createTypeMap(Person.class, PersonDTOv1.class).
                addMapping(Person::getId, PersonDTOv1::setKey);
        mapper.createTypeMap(PersonDTOv1.class, Person.class).
                addMapping(PersonDTOv1::getKey, Person::setId);

        mapper.createTypeMap(Book.class, BookDTOv1.class).
                addMapping(Book::getId, BookDTOv1::setKey);
        mapper.createTypeMap(BookDTOv1.class, Book.class).
                addMapping(BookDTOv1::getKey, Book::setId);
    }


    public static <O,D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<>();
        for (O o : origin){
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
