package ang.neggaw.technologies.restControllers;

import ang.neggaw.technologies.entities.RoleApp;
import ang.neggaw.technologies.services.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author by: ANG
 * since: 23/10/2022 12:26
 */

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping(value = "/api/roles")
public class RoleRestController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody RoleApp r) {

        try {
            roleService.createRole(r);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            log.error("Error creating Role: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleApp> getRoleById(@PathVariable String roleId) {
        try {
            RoleApp r = roleService.getRoleById(roleId);
            if(r == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.status(HttpStatus.FOUND).body(r);
        } catch (Exception e) {
            log.error("Error getting Role with id: {}", roleId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/name/{roleName}")
    public ResponseEntity<RoleApp> getRoleByName(@PathVariable String roleName) {
        try {
            RoleApp r = roleService.getRoleByRoleName(roleName);
            if(r == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.status(HttpStatus.FOUND).body(r);
        } catch (Exception e) {
            log.error("Error getting Role with roleName: {}", roleName, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RoleApp>> allRoles() {
        try {
            List<RoleApp> roles = roleService.allRoles();
            if(roles.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return ResponseEntity.status(HttpStatus.FOUND).body(roles);
        } catch (Exception e) {
            log.error("Error getting list of Roles: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/{roleId}")
    public ResponseEntity<RoleApp> updateRole(@RequestBody RoleApp r,
                                              @PathVariable String roleId) {
        try {
            RoleApp role = roleService.updateRole(r, roleId);
            if(role == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.status(HttpStatus.OK).body(r);
        } catch (Exception e) {
            log.error("Error updating Role with id: {}", roleId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<RoleApp> deleteRoleById(@PathVariable String roleId) {
        try {
            if(!roleService.deleteRoleById(roleId)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.status(HttpStatus.OK).body(roleService.getRoleById(roleId));
        } catch (Exception e) {
            log.error("Error deleting Role with id: {}", roleId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
