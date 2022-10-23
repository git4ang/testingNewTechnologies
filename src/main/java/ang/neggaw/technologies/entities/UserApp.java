package ang.neggaw.technologies.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * author by: ANG
 * since: 22/10/2022 11:10
 */

@Entity
@Table(name = "users_tb")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder @ToString(callSuper = true)
public class UserApp extends Person {

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean enabled;

    @OneToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id")
    )
    @ToString.Exclude
    private Set<RoleApp> roles;
}
