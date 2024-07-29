package org.prog.testng;

import org.prog.spring.db.Persons;
import org.prog.spring.db.PersonsJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class SqlTests {

    @Autowired
    private PersonsJpa personsJpa;

    @Test
    public void testSpringDB() {
        for (Persons p : personsJpa.findAll()) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }
    }
}
