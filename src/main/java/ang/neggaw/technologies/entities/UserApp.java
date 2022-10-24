package ang.neggaw.technologies.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<RoleApp> roles = new ArrayList<>();
}
