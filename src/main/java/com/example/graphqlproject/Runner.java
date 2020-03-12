package com.example.graphqlproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//CommandLineRunner lets you write instructions for the program at the start of runtime
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    ArcadeGameRepository arcadeGameRepository;


    // this run method will resolve at the start of your programs runtime
    @Override
    public void run(String... args) throws Exception {
        arcadeGameRepository.save(new ArcadeGame("Pac-Man", 1, LocalDate.parse("05-22-1980", DateTimeFormatter.ofPattern(("MM-dd-uuuu")))));
        System.out.println(arcadeGameRepository.findAll());
    }
}