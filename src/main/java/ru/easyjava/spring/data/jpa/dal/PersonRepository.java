package ru.easyjava.spring.data.jpa.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.easyjava.spring.data.jpa.entity.Passport;
import ru.easyjava.spring.data.jpa.entity.Person;

/**
 * Repository for person entity.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("select p from Person p where p.passport.series = :#{#passport.series}")
    Iterable<Person> personWithPasportSeries(@Param("passport") Passport series);
}
