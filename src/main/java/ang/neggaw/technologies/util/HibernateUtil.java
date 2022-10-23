package ang.neggaw.technologies.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * author by: ANG
 * since: 22/10/2022 21:38
 */

public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory;

    private HibernateUtil() {}

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void closingSF() {
        sessionFactory.close();
    }
}
