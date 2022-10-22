package ang.neggaw.testingnewtechnologies.Models;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * author by: ANG
 * since: 22/10/2022 11:10
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Embeddable
public class Address {

    private int number;
    private String street;
    private String codePostal;
    private String city;
    private String country;
}
