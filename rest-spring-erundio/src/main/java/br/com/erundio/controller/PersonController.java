package br.com.erundio.controller;

import br.com.erundio.model.Person;
import br.com.erundio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personServices;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findAll(){
        return personServices.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable(value = "id") Long id){
        return personServices.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person create(@RequestBody Person person){
        return personServices.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Person update(@RequestBody Person person){
        return personServices.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable(value = "id") Long id){
        personServices.delete(id);
    }
}
