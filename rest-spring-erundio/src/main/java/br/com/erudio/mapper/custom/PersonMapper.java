package br.com.erudio.mapper.custom;

import br.com.erudio.dto.v2.PersonDTOv2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person){
        PersonDTOv2 dtOv2 = new PersonDTOv2();
        dtOv2.setId(person.getId());
        dtOv2.setFirstName(person.getFirstName());
        dtOv2.setLastName(person.getLastName());
        dtOv2.setAddress(person.getAddress());
        dtOv2.setGender(person.getGender());
        dtOv2.setBirthDay(new Date());
        return dtOv2;
    }
    public Person convertDTOToEntity(PersonDTOv2 personDTOv2){
        Person entity = new Person();
        entity.setId(personDTOv2.getId());
        entity.setFirstName(personDTOv2.getFirstName());
        entity.setLastName(personDTOv2.getLastName());
        entity.setAddress(personDTOv2.getAddress());
        entity.setGender(personDTOv2.getGender());
        //entity.setBirthDay(new Date());
        return entity;
    }
}
