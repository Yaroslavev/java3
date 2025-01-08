package org.example;

import org.example.enteties.Animal;
import org.example.enteties.AnimalType;
import org.example.enteties.Gender;
import org.example.managers.RandomDataGenerator;
import org.example.managers.SeedData;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSession();
            SeedData.seedAnimalTypes(session);
            SeedData.seedGenders(session);
            RandomDataGenerator.generateRandomData(session, 10);

            for (Animal i : session.createQuery("FROM Animal", Animal.class).getResultList()) {
                System.out.println(i);
            }

            session.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            HibernateUtil.shutdown();
        }
    }
}