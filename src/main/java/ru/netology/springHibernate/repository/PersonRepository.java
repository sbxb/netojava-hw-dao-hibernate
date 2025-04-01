package ru.netology.springHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.springHibernate.model.Person;
import ru.netology.springHibernate.model.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLivingIgnoreCase(String city);
}
