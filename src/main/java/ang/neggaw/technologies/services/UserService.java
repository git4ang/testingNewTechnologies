package ang.neggaw.technologies.services;

import ang.neggaw.technologies.entities.RoleApp;
import ang.neggaw.technologies.entities.UserApp;

import java.util.List;
import java.util.Set;

/**
 * author by: ANG
 * since: 23/10/2022 09:31
 */

public interface UserService {
    void createUser(UserApp u);
    UserApp getUserById(long id);
    List<UserApp> allUsers();
    UserApp updateUser(UserApp u, long id);
    UserApp addRoleToUser(long roleId, long userId);
    UserApp removeRoleFromUser(long roleId, long userId);

    List<RoleApp> getRoles();

    boolean deleteUserById(long id);
}
