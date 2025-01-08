package org.example.managers;

import org.example.enteties.AnimalType;
import org.example.enteties.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SeedData {
    public static void seedGenders(Session session) {
        if (session.createQuery("FROM Gender", Gender.class).getResultList().isEmpty()) {
            Transaction transaction = session.beginTransaction();

            Gender male = new Gender();
            male.setName("Male");
            Gender female = new Gender();
            female.setName("Female");

            session.persist(male);
            session.persist(female);

            transaction.commit();
        }
    }

    public static void seedAnimalTypes(Session session) {
        if (session.createQuery("FROM AnimalType", AnimalType.class).getResultList().isEmpty()) {
            Transaction transaction = session.beginTransaction();

            AnimalType cat = new AnimalType();
            cat.setName("cat");
            AnimalType dog = new AnimalType();
            dog.setName("dog");
            AnimalType bird = new AnimalType();
            bird.setName("bird");
            AnimalType hamster = new AnimalType();
            hamster.setName("hamster");
            AnimalType turtle = new AnimalType();
            turtle.setName("turtle");

            session.persist(cat);
            session.persist(dog);
            session.persist(bird);
            session.persist(hamster);
            session.persist(turtle);

            transaction.commit();
        }
    }
}