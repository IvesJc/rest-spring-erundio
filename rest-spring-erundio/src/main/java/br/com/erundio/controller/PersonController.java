package br.com.erundio.controller;

import br.com.erundio.model.Person;
import br.com.erundio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personServices;

    @GetMapping
    public List<Person> findAll(){
        return personServices.findAll();
    }
    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable(value = "id") Long id){
        return personServices.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personServices.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
