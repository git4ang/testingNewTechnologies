package ang.neggaw.technologies.repositories;

import ang.neggaw.technologies.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author by: ANG
 * since: 23/10/2022 10:52
 */

public interface UserRepository extends JpaRepository<UserApp, String> { }
