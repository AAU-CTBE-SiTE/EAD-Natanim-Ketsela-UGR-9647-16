package com.site.ActorManagement.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "actors")
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String movieName;

    // Default constructor
    public Actor() {
    }

    // Parameterized constructor
    public Actor(String name, String movieName) {
        this.name = name;
        this.movieName = movieName;
    }

}

