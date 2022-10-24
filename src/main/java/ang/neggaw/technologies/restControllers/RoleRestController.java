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
            return null;
        } catch (Exception e) {
            log.error("Error ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleApp> getRoleById(@PathVariable String roleId) {
        try {
            return null;
        } catch (Exception e) {
            log.error("Error ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/name/{roleName}")
    public ResponseEntity<RoleApp> getRoleByName(@PathVariable String roleName) {
        try {
            return null;
        } catch (Exception e) {
            log.error("Error ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RoleApp>> allRoles() {
        try {
            return null;
        } catch (Exception e) {
            log.error("Error ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/{roleId}")
    public ResponseEntity<RoleApp> updateRole(@PathVariable String roleId) {
        try {
            return null;
        } catch (Exception e) {
            log.error("Error ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<RoleApp> deleteRoleById(@PathVariable String roleId) {
        try {
            return null;
        } catch (Exception e) {
            log.error("Error ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
