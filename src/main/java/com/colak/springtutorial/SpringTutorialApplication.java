package com.colak.springtutorial;


import com.colak.springtutorial.jpa.Person;
import com.colak.springtutorial.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringTutorialApplication implements CommandLineRunner {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<Person> list = getPersonList();

        List<Person> savedPersonList = personService.create(list);
        log.info("Saved Person id : {}", savedPersonList);

        List<Person> byFormattedBirthDate = personService.findByBirthDateYear("1976");
        log.info("byFormattedBirthDate : {}", byFormattedBirthDate);
    }

    private static List<Person> getPersonList() {
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setName("John");
        LocalDateTime localDateTime1 = LocalDateTime.of(1976, 2, 6, 0, 0);
        person1.setBirthDate(localDateTime1);
        list.add(person1);

        Person person2 = new Person();
        person2.setName("Jane");
        LocalDateTime localDateTime2 = LocalDateTime.of(2004, 11, 29, 0, 0);
        person2.setBirthDate(localDateTime2);
        list.add(person2);
        return list;
    }
}
