package br.com.erudio.services;

import br.com.erudio.dto.mapper.PersonDTOMapper;
import br.com.erudio.exceptions.ResourceNotFoundExecption;
import br.com.erudio.model.Person;
import br.com.erudio.dto.PersonDTO;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonDTOMapper mapper;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll(){
        logger.info("Finding all people!");
        return personRepository.
                findAll().
                stream().
                map(mapper).
                toList();
    }


    public PersonDTO findById(Long id){
        logger.info("Finding one person!");
        return personRepository.
                findById(id).
                map(mapper).
                orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID"));
    }


    public Person create(Person person){
        logger.info("Creating one person!");
        return personRepository.save(person);

    }
    public Person update(PersonDTO personDTO){
        logger.info("Updating one person!");

        Optional<Person> optionalPerson = personRepository.findById(personDTO.id());
        if (optionalPerson.isPresent()){
            Person person = optionalPerson.get();
            person.setFirstName(personDTO.firstName());
            person.setLastName(personDTO.lastName());
            person.setAdress(personDTO.lastName());
            person.setGender(personDTO.gender());
            return personRepository.save(person);
        }
        throw new ResourceNotFoundExecption("Person not found!");
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No " +
                "records found for this ID"));

        personRepository.delete(person);
    }

}
