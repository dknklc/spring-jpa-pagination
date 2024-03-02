package com.dekankilic.jpapagination.controller;

import com.dekankilic.jpapagination.model.Person;
import com.dekankilic.jpapagination.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<Person>> findAllWithPagination(@RequestParam int page, @RequestParam int size){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.findPeopleWithPagination(page, size));
    }

    @GetMapping("/pagination-with-sorting")
    public ResponseEntity<List<Person>> findAllWithPaginationAndSorting(@RequestParam int page, @RequestParam int size, @RequestParam(defaultValue = "firstName") String sortBy){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personService.findPeopleWithPaginationAndSorting(page, size, sortBy));
    }
}
