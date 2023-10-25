package com.example.hibernate_hw1.Repository;

import com.example.hibernate_hw1.Entity.Persons;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class DataRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public DataRepository() {
    }
    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        Persons persons1 = Persons.builder()
                .name("Ксения")
                .surname("Гунбина")
                .age(29)
                .cityOfLiving("Санкт-Петербург")
                .phoneNumber("+79994567788")
                .build();
        entityManager.persist(persons1);

        Persons persons2 = Persons.builder()
                .name("Алексей")
                .surname("Смирнов")
                .age(34)
                .cityOfLiving("Moscow")
                .phoneNumber("+79213453344")
                .build();
        entityManager.persist(persons2);

         List<Persons> list = entityManager.createNativeQuery(
                "SELECT * FROM netology.Persons WHERE city_of_living LIKE :citySql", Persons.class)
                 .setParameter("citySql", city)
                 .getResultList();
        return list;


        //return entityManager.find(Persons.class, city);
    }

}
