package com.example.hibernate_hw1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persons", schema = "netology")
@Entity
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "surname")
    private String surname;

    @Column(nullable = false, name = "age")
    private int age;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "city_of_living")
    private String cityOfLiving;

    public void setId(Long id) {
        this.id = id;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persons persons)) return false;
        return getId().equals(persons.getId()) && Objects.equals(getName(), persons.getName()) && Objects.equals(getSurname(), persons.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname());
    }
}
