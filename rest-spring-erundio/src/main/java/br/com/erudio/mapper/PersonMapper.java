package br.com.erudio.mapper;

import br.com.erudio.model.Person;
import br.com.erudio.dto.PersonDTO;

public class PersonMapper {

    public static Person mapToPerson(PersonDTO personDTO){
        Person person = new Person(
                personDTO.id(),
                personDTO.firstName(),
                personDTO.lastName(),
                personDTO.adress(),
                personDTO.gender()
        );
        return person;
    }

    public static PersonDTO mapToPersonRecord(Person person){
        PersonDTO personDTO = new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAdress(),
                person.getGender()
        );
        return personDTO;
    }

}
