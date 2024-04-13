package br.com.erundio.services;

import br.com.erundio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all people!");
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            personList.add(person);
        }
        return personList;
    }


    public Person findById(String id){
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAdress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");
        return person;
    }
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name "+i);
        person.setLastName("Person last name "+i);
        person.setAdress("Person address "+i);
        person.setGender("Person gender "+i);
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one person!");

        return person;

    }
    public Person update(Person person){
        logger.info("Updating one person!");
        return person;

    }

    public void delete(String id){
        logger.info("Deleting one person!");
    }

}
