package ang.neggaw.testingnewtechnologies.entities;

import ang.neggaw.testingnewtechnologies.Models.Address;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * author by: ANG
 * since: 22/10/2022 11:09
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder @ToString
@MappedSuperclass
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private LocalDate birthdate;

    @Embedded
    private Address address;
}
