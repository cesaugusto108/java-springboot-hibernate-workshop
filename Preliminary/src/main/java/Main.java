import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

//        Person person1 = new Person(null, "José da Silva", "jose@email.com");
//        Person person2 = new Person(null, "Carlos Moreira", "carlos@email.com");
//        Person person3 = new Person(null, "Karol Santos", "karol@email.com");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person p = entityManager.find(Person.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println(p);
    }
}
