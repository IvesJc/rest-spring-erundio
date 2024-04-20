package br.com.erudio.services;

import br.com.erudio.dto.mapper.ModelMapper;
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
        return ModelMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }


    public PersonDTO findById(Long id){
        logger.info("Finding one person!");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID!"));
        return ModelMapper.parseObject(entity, PersonDTO.class);
    }


    public PersonDTO create(PersonDTO personDTO){
        // recebe DTO       ^^^^^^^^^^^^^^^^^^^^
        logger.info("Creating one person!");
        Person entity = ModelMapper.parseObject(personDTO, Person.class);
        // converte o DTO para a entidade       ^^^^^^^^^^^^^^^^^^^^^^^
        var entidade = personRepository.save(entity);
        return ModelMapper.parseObject(entidade, PersonDTO.class);
        //                             ^^^^^^^^^^^^^^^^^^^^^^^^^
        // pra finalizar, converte entidade em DTO

    }
    public PersonDTO update(PersonDTO personDTO){
        logger.info("Updating one person!");

        Person entity =
                personRepository.findById(personDTO.getId()).orElseThrow(() -> new ResourceNotFoundExecption(
                        "No records found for this ID"));
        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName((personDTO.getLastName()));
        entity.setAdress(personDTO.getAdress());
        entity.setGender(personDTO.getGender());

        return ModelMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No " +
                "records found for this ID"));

        personRepository.delete(person);
    }

}
