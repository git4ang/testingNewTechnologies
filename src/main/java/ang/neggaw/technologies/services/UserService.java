package ang.neggaw.technologies.services;

import ang.neggaw.technologies.entities.RoleApp;
import ang.neggaw.technologies.entities.UserApp;

import java.util.List;

/**
 * author by: ANG
 * since: 23/10/2022 09:31
 */

public interface UserService {
    void createUser(UserApp u);
    UserApp getUserById(String id);
    List<UserApp> allUsers();
    UserApp updateUser(UserApp u, String id);
    UserApp addRoleToUser(String roleId, String userId);
    UserApp removeRoleFromUser(String roleId, String userId);
    List<RoleApp> getRoles();
    boolean deleteUserById(String id);
}
