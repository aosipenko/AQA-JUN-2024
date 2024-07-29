package org.prog.spring.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonsJpa extends JpaRepository<Persons, Long> {

    @Query(nativeQuery = true, value = "SELECT * from Persons p ORDER BY rand() LIMIT 1")
    Optional<Persons> getRandomPerson();
}