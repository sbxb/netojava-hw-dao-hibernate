package ru.netology.springHibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.springHibernate.model.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Person> getPersonsByCity(String city) {
        return em.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList()
                .stream()
                .filter(p -> p.getCityOfLiving().toLowerCase().equals(city.toLowerCase()))
                .toList();
    }
}
