package com.example.hibernate_hw1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persons", schema = "netology")
@Entity
public class Persons {

    @Column(nullable = false, name = "id")
    private Long id;

    @EmbeddedId
    private PersonsPK pk;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "city_of_living")
    private String cityOfLiving;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }
    public void setPk(PersonsPK pk) {
        this.pk = pk;
    }

    public Long getId() {
        return id;
    }

    public PersonsPK getPk() {
        return pk;
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
                ", name='" + pk.getName() + '\'' +
                ", surname='" + pk.getSurname() + '\'' +
                ", age=" + pk.getAge() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persons persons)) return false;
        return Objects.equals(getPk(), persons.getPk()) && Objects.equals(getId(), persons.getId()) && Objects.equals(getPhoneNumber(), persons.getPhoneNumber()) && Objects.equals(getCityOfLiving(), persons.getCityOfLiving());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getId(), getPhoneNumber(), getCityOfLiving());
    }
}
