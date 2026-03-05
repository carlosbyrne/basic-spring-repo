package com.makers.makersbnb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

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
    private String name;
    // a third field storing the description of each space
    private String description;
    // a third field storing the price of each space
    private Double price;
    // a fourth field storing the rules
    private String rules;

    // a zero-arguments constructor
    public Space() {}


    // a one-argument constructor
    public Space(String name) {
        this.name = name;
    }

    // get and set methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getRules() { return rules; }
    public void setRules(String rules) { this.rules = rules; }
}


