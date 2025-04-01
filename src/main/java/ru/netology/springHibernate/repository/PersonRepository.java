package ru.netology.springHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.springHibernate.model.Person;
import ru.netology.springHibernate.model.PersonId;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLivingIgnoreCase(String city);

    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<Person> findOneByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);
}
