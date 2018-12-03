package com.wildcodeschool.example.pokemonGO.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pokemon {

    public Pokemon() {
    }

    public Pokemon(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String firstName;

    private int age;

    @Override
    public String toString() { 
        return "Pokemon [id=" + id + ", firstName=" + firstName
                + ", age=" + age + "]";
    }                    

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    

}
