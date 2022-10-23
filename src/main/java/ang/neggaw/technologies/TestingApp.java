package ang.neggaw.technologies;

import ang.neggaw.technologies.entities.UserApp;
import ang.neggaw.technologies.util.HibernateUtil;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class TestingApp {
    public static void main(String[] args) {
        SpringApplication.run(TestingApp.class, args);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.get(UserApp.class, 1L);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Error getting user with id: {}. {}", "1", e.getMessage());
        }
    }
}
