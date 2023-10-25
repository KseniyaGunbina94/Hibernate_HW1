package com.example.hibernate_hw1.Config;

import Controller.Controller;
import com.example.hibernate_hw1.Repository.DataRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public DataRepository repository(){
        return new DataRepository();
    }

    @Bean
    public Controller controller(DataRepository repository){
        return new Controller(repository);
    }
}
