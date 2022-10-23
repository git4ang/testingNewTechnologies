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
import java.util.stream.Stream;

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
    public UserApp getUserById(long id) {
        return null;
    }

    @Override
    public List<UserApp> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserApp updateUser(UserApp u, long id) {
        return null;
    }

    @Override
    public UserApp addRoleToUser(long roleId, long userId) {
        return null;
    }

    @Override
    public UserApp removeRoleFromUser(long roleId, long userId) {
        return null;
    }

    @Override
    public List<RoleApp> getRoles() {
        return new ArrayList<>(roleService.allRoles());
    }

    @Override
    public boolean deleteUserById(long id) {
        return false;
    }
}
