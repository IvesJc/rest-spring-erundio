package br.com.erundio.services;

import br.com.erundio.exceptions.ResourceNotFoundExecption;
import br.com.erundio.model.Person;
import br.com.erundio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all people!");
        return personRepository.findAll();
    }


    public Person findById(Long id){
        logger.info("Finding one person!");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Creating one person!");
        return personRepository.save(person);

    }
    public Person update(Person person){
        logger.info("Updating one person!");
        Person entity =
                personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundExecption("No " +
                "records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);

    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No " +
                "records found for this ID"));

        personRepository.delete(person);
    }

}
