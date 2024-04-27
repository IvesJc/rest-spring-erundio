package br.com.erudio.controller;

import br.com.erudio.dto.v1.PersonDTOv1;
import br.com.erudio.dto.v2.PersonDTOv2;
import br.com.erudio.services.PersonService;
import br.com.erudio.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personServices;

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    public List<PersonDTOv1> findAll(){
        return personServices.findAll();
    }
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    public PersonDTOv1 findById(@PathVariable(value = "id") Long id){
        return personServices.findById(id);
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    public PersonDTOv1 create(@RequestBody PersonDTOv1 person){
        return personServices.create(person);
    }

    // V2 with new attribute
    @PostMapping(
            value = "/v2",
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    public PersonDTOv2 createV2(@RequestBody PersonDTOv2 person){
        return personServices.createV2(person);
    }

    @PutMapping(
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    public PersonDTOv1 update(@RequestBody PersonDTOv1 person){
        return personServices.update(person);
    }

    @DeleteMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_XML,
                        MediaType.APPLICATION_YAML
            })
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
