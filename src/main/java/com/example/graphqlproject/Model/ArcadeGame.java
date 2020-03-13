package com.example.graphqlproject.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArcadeGame {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String amountOfPlayers;

    public ArcadeGame(String id, String name, String amountOfPlayers) {
        this.id = id;
        this.name = name;
        this.amountOfPlayers = amountOfPlayers;
    }

    public ArcadeGame(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public void setAmountOfPlayers(String amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }



    @Override
    public String toString() {
        return "ArcadeGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountOfPlayers=" + amountOfPlayers +
                '}';
    }
}
