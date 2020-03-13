package com.example.graphqlproject;


import com.example.graphqlproject.GraphQL.GraphQLDataFetchers;
import com.example.graphqlproject.Model.ArcadeGame;
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
    GraphQLDataFetchers graphQLDataFetchers;

    // this run method will resolve at the start of your programs runtime
    @Override
    public void run(String... args) throws Exception {
        arcadeGameRepository.save(new ArcadeGame("0", "Pac-Man", "1"));
        arcadeGameRepository.save(new ArcadeGame("1","Ms. Pac-Man", "1"));
        arcadeGameRepository.save(new ArcadeGame("2","Pong", "2"));
        GraphQLDataFetchers.arcadeGameList =  StreamSupport
                .stream(arcadeGameRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        System.out.println("Data Saved!");
        System.out.println(GraphQLDataFetchers.arcadeGameList);
    }
}