package ang.neggaw.technologies.services;

import ang.neggaw.technologies.entities.RoleApp;
import ang.neggaw.technologies.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author by: ANG
 * since: 23/10/2022 08:29
 */

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void createRole(RoleApp r) {

        try {
            roleRepository.save(r);
        } catch (Exception e) {
            log.error("Error creating new role. {}", e.getMessage());
        }
    }

    @Override
    public RoleApp getRoleById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public RoleApp getRoleByRoleName(String admin) {
        return roleRepository.findByRoleName(admin);
    }

    @Override
    public List<RoleApp> allRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleApp updateRole(RoleApp r, String id) {

        RoleApp role = getRoleById(id);
        if(role == null) return null;
        return roleRepository.saveAndFlush(r);
    }

    @Override
    public boolean deleteRoleById(String id) {

        RoleApp role = getRoleById(id);
        if(role == null) return false;
        roleRepository.delete(role);
        return true;
    }
}
