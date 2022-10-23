package ang.neggaw.technologies.services;

import ang.neggaw.technologies.entities.RoleApp;

import java.util.List;

/**
 * author by: ANG
 * since: 23/10/2022 08:29
 */

public interface RoleService {
    void createRole(RoleApp r);
    RoleApp getRoleById(long id);
    RoleApp getRoleByRoleName(String admin);
    List<RoleApp> allRoles();
    RoleApp updateRole(RoleApp r, long id);
    boolean deleteRoleById(long id);

}
