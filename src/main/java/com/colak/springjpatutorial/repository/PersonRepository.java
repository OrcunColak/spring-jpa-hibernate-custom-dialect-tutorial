package com.colak.springjpatutorial.repository;

import com.colak.springjpatutorial.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p FROM Person p WHERE date_format(p.birthDate, 'Y') = :year")
    List<Person> findByBirthDateYear(String year);
}
