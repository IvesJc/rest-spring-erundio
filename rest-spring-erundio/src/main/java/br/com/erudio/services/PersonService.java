package br.com.erudio.services;

import br.com.erudio.controller.PersonController;
import br.com.erudio.dto.v2.PersonDTOv2;
import br.com.erudio.exceptions.RequiredObjectIsNullExecption;
import br.com.erudio.mapper.ModelMapper;
import br.com.erudio.exceptions.ResourceNotFoundExecption;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.dto.v1.PersonDTOv1;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper mapper;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonDTOv1> findAll(){
        logger.info("Finding all people!");
        List<PersonDTOv1> dtos = ModelMapper.parseListObjects(personRepository.findAll(), PersonDTOv1.class);
        dtos.
            forEach(p -> p.add(linkTo(methodOn(PersonController.class).
            findById(p.getKey())).
            withSelfRel()));
        return dtos;
    }


    public PersonDTOv1 findById(Long id){
        logger.info("Finding one person!");
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No records found for this ID!"));

        PersonDTOv1 dto = ModelMapper.parseObject(entity, PersonDTOv1.class);
        dto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return dto;
    }


    public PersonDTOv1 create(PersonDTOv1 personDTOv1){
        // recebe DTO       ^^^^^^^^^^^^^^^^^^^^

        if (personDTOv1 == null) throw new RequiredObjectIsNullExecption();
        logger.info("Creating one person!");
        Person entity = ModelMapper.parseObject(personDTOv1, Person.class);
        // converte o DTO para a entidade       ^^^^^^^^^^^^^^^^^^^^^^^
        Person entidade = personRepository.save(entity);
        PersonDTOv1 dto = ModelMapper.parseObject(entidade, PersonDTOv1.class);
        //                             ^^^^^^^^^^^^^^^^^^^^^^^^^
        // pra finalizar, converte entidade em DTO
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }
    public PersonDTOv2 createV2(PersonDTOv2 personDTOv2){
        // recebe DTO       ^^^^^^^^^^^^^^^^^^^^
        logger.info("Creating one person with V2!");
        Person entity = mapper.convertDTOToEntity(personDTOv2);
        // converte o DTO para a entidade       ^^^^^^^^^^^^^^^^^^^^^^^
        var entidade = personRepository.save(entity);
        return mapper.convertEntityToDTO(entidade);
        //                             ^^^^^^^^^^^^^^^^^^^^^^^^^
        // pra finalizar, converte entidade em DTO
    }
    public PersonDTOv1 update(PersonDTOv1 personDTOv1){
        if (personDTOv1 == null) throw new RequiredObjectIsNullExecption();
        logger.info("Updating one person!");

        Person entity =
                personRepository.findById(personDTOv1.getKey()).orElseThrow(() -> new ResourceNotFoundExecption(
                        "No records found for this ID"));
        entity.setFirstName(personDTOv1.getFirstName());
        entity.setLastName((personDTOv1.getLastName()));
        entity.setAddress(personDTOv1.getAddress());
        entity.setGender(personDTOv1.getGender());

        PersonDTOv1 dto =ModelMapper.parseObject(personRepository.save(entity), PersonDTOv1.class);
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExecption("No " +
                "records found for this ID"));

        personRepository.delete(person);
    }

}
