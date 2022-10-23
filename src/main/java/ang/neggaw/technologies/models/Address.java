package ang.neggaw.technologies.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * author by: ANG
 * since: 22/10/2022 11:10
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Embeddable
public class Address implements Serializable {

    private int number;
    private String street;
    private String codePostal;
    private String city;
    private String country;
}
