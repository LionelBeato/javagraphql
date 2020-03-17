package com.example.graphqlproject;


import com.example.graphqlproject.GraphQL.GraphQLDataFetchers;
import com.example.graphqlproject.Model.Animal;
import com.example.graphqlproject.Model.ArcadeGame;
import com.example.graphqlproject.Repository.AnimalRepository;
import com.example.graphqlproject.Repository.ArcadeGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


//CommandLineRunner lets you write instructions for the program at the start of runtime
@Component
public class Runner implements CommandLineRunner {

    @Autowired
    ArcadeGameRepository arcadeGameRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    // this run method will resolve at the start of your programs runtime
    @Override
    public void run(String... args) throws Exception {
//        arcadeGameRepository.save(new ArcadeGame( "Pac-Man", 1));
//        arcadeGameRepository.save(new ArcadeGame("Ms. Pac-Man", 1));
//        arcadeGameRepository.save(new ArcadeGame("Pong", 2));
        // this code block turns our repository into a workable list
        GraphQLDataFetchers.arcadeGameList =  StreamSupport
                .stream(arcadeGameRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        Animal testAnimal = new Animal(4,  "Wolf");

//        animalRepository.save(new Animal( 0, "Snake"));
//        animalRepository.save(new Animal( 4, "Cat"));
//        animalRepository.save(testAnimal);


        GraphQLDataFetchers.animalList = StreamSupport
                .stream(animalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());



        System.out.println("Data Saved!");
        System.out.println(testAnimal.getId());
        System.out.println(GraphQLDataFetchers.arcadeGameList);
        System.out.println(GraphQLDataFetchers.animalList);
    }
}