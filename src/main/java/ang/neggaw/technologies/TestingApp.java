package ang.neggaw.technologies;

import ang.neggaw.technologies.entities.RoleApp;
import ang.neggaw.technologies.entities.UserApp;
import ang.neggaw.technologies.models.Address;
import ang.neggaw.technologies.services.RoleService;
import ang.neggaw.technologies.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@SpringBootApplication
@Log4j2
public class TestingApp {

    public static void main(String[] args) { SpringApplication.run(TestingApp.class, args); }

    @Bean
    CommandLineRunner runner(RoleService roleService,
                             UserService userService) {
        return args -> {

            // role DB
            roleService.createRole(new RoleApp(UUID.randomUUID().toString(), "ADMIN"));
            roleService.createRole(new RoleApp(UUID.randomUUID().toString(), "USER"));
            roleService.createRole(new RoleApp(UUID.randomUUID().toString(), "GUEST"));

            // address
            Address address = new Address(1, "Av street", "13000", "Marseille", "France");

            // user DB
            UserApp user = UserApp.builder()
                    .username("admin").password("1234").email("admin@email.com")
                    .enabled(true)
                    .build();
            user.setId(UUID.randomUUID().toString());
            user.setBirthdate(LocalDate.of(Integer.parseInt("1990"), Month.AUGUST, 20));
            user.setAddress(address);
            userService.createUser(user);
        };
    }
}
