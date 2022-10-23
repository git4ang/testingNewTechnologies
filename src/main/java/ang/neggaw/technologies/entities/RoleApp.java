package ang.neggaw.technologies.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
public class RoleApp implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String roleId;

    private String roleName;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    @ToString.Exclude
//    private Set<UserApp> users;

}
