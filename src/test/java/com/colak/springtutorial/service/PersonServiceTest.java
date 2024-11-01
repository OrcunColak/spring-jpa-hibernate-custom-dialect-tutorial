package com.colak.springtutorial.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void findNamesWithSuffix() {
        List<String> personList = personService.findNamesWithSuffix("suffix");
        assertThat(personList)
                .allMatch(name -> name.endsWith("suffix"), "All names should end with the specified suffix");
    }
}