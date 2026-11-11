package com.site.actor_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String movieName;
}