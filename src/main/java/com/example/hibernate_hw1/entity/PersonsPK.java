package com.example.hibernate_hw1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonsPK implements Serializable {
    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "surname")
    private String surname;

    @Column(nullable = false, name = "age")
    private int age;

    public PersonsPK() {
    }

    public PersonsPK(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
}
