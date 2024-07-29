package org.prog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prog.spring.db.Persons;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String gender;
    private String nat;
    private NameDto name;

    public static PersonDto fromTable(Persons persons) {
        return PersonDto.builder()
                .gender(persons.getGender())
                .nat(persons.getNat())
                .name(NameDto.builder()
                        .title(persons.getTitle())
                        .last(persons.getLastName())
                        .first(persons.getFirstName())
                        .build())
                .build();
    }
}
