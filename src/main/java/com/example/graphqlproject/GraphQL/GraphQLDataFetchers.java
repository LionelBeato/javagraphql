package com.example.graphqlproject.GraphQL;

import com.example.graphqlproject.Model.ArcadeGame;
import com.example.graphqlproject.Repository.ArcadeGameRepository;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// This component acts as a way to fetch and access our data
// You can call this component your service
// its taking care of all of your business logic
@Component
public class GraphQLDataFetchers {

    @Autowired
    ArcadeGameRepository arcadeGameRepository;


    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"),
            ImmutableMap.of("id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice")
    );


    public static List<ArcadeGame> arcadeGameList;



    public DataFetcher getBookByIdDataFetcher() {
        // DataFetchingEnvironment is an anonymous inner class
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }


    public DataFetcher getArcadeGameByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String arcadeGameId = dataFetchingEnvironment.getArgument("id");
            return arcadeGameList
                    .stream()
                    .filter(game -> game.getId().equals(arcadeGameId))
                    .findFirst()
                    .orElse(null);

        };
    }


    public DataFetcher getArcadeGamesFetcher(){
        return dataFetchingEnvironment -> {
            // TODO: get a working match for this query
            String match = dataFetchingEnvironment.getArgument("match");
            return arcadeGameList;


        };
    }
}


