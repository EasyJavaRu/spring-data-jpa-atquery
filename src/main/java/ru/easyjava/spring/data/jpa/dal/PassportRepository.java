package ru.easyjava.spring.data.jpa.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.easyjava.spring.data.jpa.entity.Passport;

import javax.persistence.QueryHint;

/**
 * Repository for passport entity.
 */
public interface PassportRepository extends CrudRepository<Passport, Long> {
    @QueryHints(@QueryHint(name = "org.hibernate.readOnly", value = "true"))
    @Query("select p from Passport p where p.owner.lastName = :name")
    Iterable<Passport> findByOwner(@Param("name") String name);

    @Query("select p from Passport p where p.owner.lastName like ?1%")
    Iterable<Passport> ownerStartsWith(String name);
}
