package com.dekankilic.jpapagination.service;

import com.dekankilic.jpapagination.model.Person;
import com.dekankilic.jpapagination.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> findPeopleWithPagination(int pageNo, int pageSize ){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Person> result = personRepository.findAll(pageable);
        return result.getContent();
    }

    public List<Person> findPeopleWithPaginationAndSorting(int pageNo, int pageSize, String sortBy){
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Person> result = personRepository.findAll(pageable);
        return result.getContent();
    }
}
