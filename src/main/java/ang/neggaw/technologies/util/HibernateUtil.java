package ang.neggaw.technologies.util;

import ang.neggaw.technologies.entities.RoleApp;
import ang.neggaw.technologies.entities.UserApp;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * author by: ANG
 * since: 22/10/2022 21:38
 */

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    private HibernateUtil() {}

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void closingSF() {
        sessionFactory.close();
    }

    public static SessionFactory getSessionFactory() { return sessionFactory; }
}
