package com.makers.makersbnb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// @Entity - instances of this class map to database records
@SuppressWarnings("ALL")
@Entity
// @Table - those records can be found in the spaces table
@Table(name = "SPACES")
public class Space {

    // the following field (id) is the primary key for this Entity
    @Id
    // the value of id is generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // a second field that holds the name of each space
    @Getter
    @Setter
    private String name;

    // a third field storing the description of each space
    @Getter
    @Setter
    private String description;

    // a third field storing the price of each space
    @Getter
    @Setter
    private Double price;

    // a fourth field storing the rules
    @Getter
    @Setter
    private String rules;

    // a zero-arguments constructor
    public Space() {}


    // a one-argument constructor
    public Space(String name) {
        this.name = name;
    }


}


