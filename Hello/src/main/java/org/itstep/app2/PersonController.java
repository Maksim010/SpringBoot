package org.itstep.app2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private List<Person> persons=new ArrayList<>();
    {
        persons.add(new Person(1L,"Max","Drobysh"));
        persons.add(new Person(2L,"Yan","Drobysh"));
        persons.add(new Person(3L,"John","Drobysh"));
    }
    @GetMapping("")
    public List<Person> getAllPersons(){
        return persons;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> getAllPersons(@PathVariable("id") Long id){
        Person person=persons.stream().filter(p->p.getId().equals(id)).
                findFirst()
                .orElse(null);
        if(person==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(person,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Person> createAllPersons(@RequestBody Person person){
        persons.add(person);
            return new ResponseEntity<>(person,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id,@RequestBody Person person){
        Person personOld=persons.stream().filter(p->p.getId().equals(id)).
                findFirst()
                .orElse(null);
        if(person==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        personOld.setName(person.getName());
        personOld.setSurname(person.getSurname());
         return new ResponseEntity<>(person,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id){
        Person person=persons.stream().filter(p->p.getId().equals(id)).
                findFirst()
                .orElse(null);
        if(person==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        persons.remove(person);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}


/*
  fetch('
http://localhost:8080/users
', {
    method: 'GET'
  })
  .then(response=>response.json());

fetch('
http://localhost:8080/users
', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({"name": "Jane"})
          });

  fetch('http://localhost:8080/persons', {
    method: 'PUT',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({"id":4 ,name:"Jane" ,surname:"Reta"})
  });

  fetch('
http://localhost:8080/users/1
', {
    method: 'DELETE'
  });
 */
