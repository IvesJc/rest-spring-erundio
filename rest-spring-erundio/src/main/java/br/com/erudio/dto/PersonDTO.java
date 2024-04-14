package br.com.erudio.dto;

import br.com.erudio.model.Person;

public record PersonDTO(
        Long id,
        String firstName,
        String lastName,
        String adress,
        String gender) {

//    public PersonDTO(Person person) {
//        this(person.getId(),
//            person.getFirstName(),
//            person.getLastName(),
//            person.getAdress(),
//            person.getGender());
//    }
}
