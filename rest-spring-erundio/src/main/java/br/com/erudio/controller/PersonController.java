package br.com.erudio.controller;

import br.com.erudio.model.Person;
import br.com.erudio.dto.PersonDTO;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personServices;

    @GetMapping
    public List<PersonDTO> findAll(){
        return personServices.findAll();
    }
    @GetMapping(value = "/{id}")
    public PersonDTO findById(@PathVariable(value = "id") Long id){
        return personServices.findById(id);
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO person){
        return personServices.create(person);
    }

    @PutMapping
    public PersonDTO update(@RequestBody PersonDTO person){
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
