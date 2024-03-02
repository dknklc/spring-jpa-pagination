package com.dekankilic.jpapagination.service;

import com.dekankilic.jpapagination.model.Address;
import com.dekankilic.jpapagination.model.Person;
import com.dekankilic.jpapagination.repository.PersonRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoaderService implements CommandLineRunner {
    private final PersonRepository personRepository;
    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Sample Data...");
        List<Person> persons = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Person(
                        null,
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                null,
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                ))
                .toList();

        personRepository.saveAll(persons);
    }
}
