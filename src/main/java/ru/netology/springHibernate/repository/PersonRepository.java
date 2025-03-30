package ru.netology.springHibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.springHibernate.model.Person;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    public Person getPersonsByCity(String city) {
        return em.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList()
                .stream()
                .filter(p -> p.getCityOfLiving().toLowerCase().equals(city.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
}
