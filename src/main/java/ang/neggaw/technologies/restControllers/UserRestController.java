package ang.neggaw.technologies.restControllers;

import ang.neggaw.technologies.entities.UserApp;
import ang.neggaw.technologies.services.UserService;
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
@RequestMapping(value = "/api/users")
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserApp u) {

        try {
            userService.createUser(u);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Error creating user: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserApp> getUserById(@PathVariable(value = "userId") String id) {

        try {
            UserApp u = userService.getUserById(id);
            if(u == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.status(HttpStatus.FOUND).body(u);
        } catch (Exception e) {
            log.error("Error getting User with id: {}", id, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UserApp>> allUsers() {

        try {
            List<UserApp> users = userService.allUsers();
            if(users.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            return ResponseEntity.status(HttpStatus.FOUND).body(users);
        } catch (Exception e) {
            log.error("", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping(value = "/{userID}")
    public ResponseEntity<UserApp> updateUser(@RequestBody UserApp u, @PathVariable String userId) {

        try {
            UserApp user = userService.updateUser(u, userId);
            if(user == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.status(HttpStatus.OK).body(u);
        } catch (Exception e) {
            log.error("Error updating User with id: {}", userId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/add/{roleId}/{userId}")
    public ResponseEntity<UserApp> addRoleToUser(@PathVariable String roleId,
                                                 @PathVariable String userId) {

        try {
            UserApp u = userService.addRoleToUser(roleId, userId);
            if(u == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.status(HttpStatus.OK).body(u);
        } catch (Exception e) {
            log.error("Error adding Role with id: {} to User with id: {}", roleId, userId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/remove/{roleId}/{userId}")
    public ResponseEntity<UserApp> removeRoleFromUser(@PathVariable String roleId,
                @PathVariable String userId) {
        
        try {
            UserApp u = userService.removeRoleFromUser(roleId, userId);
            if(u == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.status(HttpStatus.OK).body(u);
        } catch (Exception e) {
            log.error("Error adding Role with id: {} to User with id: {}", roleId, userId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable String userId) {

        try {
            if(userService.deleteUserById(userId)) return ResponseEntity.status(HttpStatus.OK).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            log.error("Error deleting User with id: {}", userId, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
