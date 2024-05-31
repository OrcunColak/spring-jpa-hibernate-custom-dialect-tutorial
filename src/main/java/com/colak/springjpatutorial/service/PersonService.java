package com.colak.springjpatutorial.service;

import com.colak.springjpatutorial.jpa.Person;
import com.colak.springjpatutorial.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    @Transactional
    public List<Person> create(List<Person> personList) {
        return repository.saveAll(personList);
    }

    @Transactional(readOnly = true)
    public List<Person> findByBirthDateYear(String year) {
        return repository.findByBirthDateYear(year);
    }
}
