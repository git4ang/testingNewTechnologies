package ang.neggaw.technologies.services;

import ang.neggaw.technologies.entities.RoleApp;
import ang.neggaw.technologies.entities.UserApp;
import ang.neggaw.technologies.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author by: ANG
 * since: 23/10/2022 09:34
 */

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;


    @Override
    public void createUser(UserApp u) {

        try {
            userRepository.save(u);
            u.setRoles(Collections.singletonList(roleService.getRoleByRoleName("GUEST")));
        } catch (Exception e) {
            log.error("Error creating new user: ", e);
        }
    }

    @Override
    public UserApp getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserApp> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserApp updateUser(UserApp u, String id) {

        UserApp user = getUserById(id);
        if(user == null) return null;
        return userRepository.saveAndFlush(u);
    }

    @Override
    public UserApp addRoleToUser(String roleId, String userId) {

        UserApp u = getUserById(userId);
        RoleApp r = roleService.getRoleById(roleId);

        if(u == null || r == null) return null;
        u.getRoles().add(r);
        r.setUser(u);
        roleService.updateRole(r, roleId);
        return userRepository.saveAndFlush(u);
    }

    @Override
    public UserApp removeRoleFromUser(String roleId, String userId) {

        UserApp u = getUserById(userId);
        RoleApp r = roleService.getRoleById(roleId);

        if(u == null || r == null) return null;
        u.getRoles().remove(r);
        r.setUser(null);
        roleService.updateRole(r, roleId);
        return userRepository.saveAndFlush(u);
    }

    @Override
    public List<RoleApp> getRoles() {
        return new ArrayList<>(roleService.allRoles());
    }

    @Override
    public boolean deleteUserById(String id) {
        UserApp user = getUserById(id);
        if(user == null) return false;
        userRepository.delete(user);
        return true;
    }
}
