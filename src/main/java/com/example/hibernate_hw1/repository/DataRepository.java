package com.example.hibernate_hw1.repository;

import com.example.hibernate_hw1.entity.Persons;
import com.example.hibernate_hw1.entity.PersonsPK;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Random;

@Repository
public class DataRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void enterPerson() {
        Random r = new Random();
        Persons persons1 = Persons.builder()
                .id((long) r.nextInt(1000 - 1 + 1) + 1)
                .pk(new PersonsPK("Kseniya", "Gunbina", 29))
                .cityOfLiving("Санкт-Петербург")
                .phoneNumber("+79994567788")
                .build();
        entityManager.persist(persons1);

        Persons persons2 = Persons.builder()
                .pk(new PersonsPK("Alexey", "Smirnov", 34))
                .id((long) r.nextInt(1000 - 1 + 1) + 1)
                .cityOfLiving("Moscow")
                .phoneNumber("+79213453344")
                .build();
        entityManager.persist(persons2);
    }

    public List<Persons> getPersonsByCity(String city) {
        List<Persons> list = entityManager.createQuery(
                "select с from Persons с where с.cityOfLiving like :citySql", Persons.class)
                .setParameter("citySql", city)
                .getResultList();
        return list;

    }

}
