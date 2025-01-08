package org.example.util;

import lombok.Getter;
import org.example.enteties.Animal;
import org.example.enteties.AnimalType;
import org.example.enteties.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static SessionFactory sessionFactory;

    static {
        try {
            var config = new Configuration().configure();
            config.addAnnotatedClass(AnimalType.class);
            config.addAnnotatedClass(Gender.class);
            config.addAnnotatedClass(Animal.class);

            sessionFactory = config.buildSessionFactory();
        }
        catch (Exception e ) {
            System.err.println(e.getMessage());
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}