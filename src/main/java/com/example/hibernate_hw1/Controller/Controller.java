package com.example.hibernate_hw1.Controller;

import com.example.hibernate_hw1.entity.Persons;
import com.example.hibernate_hw1.repository.DataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    DataRepository dataRepository;

    public Controller(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getProductName (@RequestParam("city") String city){
        dataRepository.enterPerson();
        return dataRepository.getPersonsByCity(city);
    }

}
