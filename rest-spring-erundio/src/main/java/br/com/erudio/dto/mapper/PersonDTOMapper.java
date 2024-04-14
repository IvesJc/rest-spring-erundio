package br.com.erudio.dto.mapper;

import br.com.erudio.dto.PersonDTO;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PersonDTOMapper implements Function<Person, PersonDTO> {
    @Override
    public PersonDTO apply(Person person) {
        return new PersonDTO(person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAdress(),
                person.getGender());
    }
}
