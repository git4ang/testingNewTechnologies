package ang.neggaw.testingnewtechnologies.entities;

import lombok.*;

import javax.persistence.*;

/**
 * author by: ANG
 * since: 22/10/2022 11:10
 */

@Entity
@Table(name = "roles_tb")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder @ToString
public class RoleApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

}
