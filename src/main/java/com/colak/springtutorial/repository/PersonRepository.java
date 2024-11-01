package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p FROM Person p WHERE date_format(p.birthDate, 'Y') = :year")
    List<Person> findByBirthDateYear(String year);

    // Custom query using concat_strings function
    @Query("SELECT concat_strings(p.name, :suffix) FROM Person p")
    List<String> findNamesWithSuffix(String suffix);
}
