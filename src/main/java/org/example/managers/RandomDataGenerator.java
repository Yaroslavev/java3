package org.example.managers;

import com.github.javafaker.Faker;
import org.example.enteties.Animal;
import org.example.enteties.AnimalType;
import org.example.enteties.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RandomDataGenerator {
    private static final Faker faker = new Faker();

    private static String generateRandomName() {
        return faker.name().firstName();
    }

    private static int generateRandomAge() {
        return faker.number().numberBetween(1, 50);
    }

    private static AnimalType generateRandomAnimalType(Session session) {
        List<AnimalType> types = session.createQuery("FROM AnimalType", AnimalType.class).getResultList();

        return types.get(faker.random().nextInt(types.size()));
    }

    private static Gender generateRandomGender(Session session) {
        List<Gender> genders = session.createQuery("FROM Gender", Gender.class).getResultList();

        return genders.get(faker.random().nextInt(genders.size()));
    }

    public static void generateRandomData(Session session, int count) {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < count; i++) {
            Animal animal = new Animal();
            animal.setName(generateRandomName());
            animal.setAge(generateRandomAge());
            animal.setAnimalType(generateRandomAnimalType(session));
            animal.setGender(generateRandomGender(session));

            session.persist(animal);
        }

        transaction.commit();
    }
}
