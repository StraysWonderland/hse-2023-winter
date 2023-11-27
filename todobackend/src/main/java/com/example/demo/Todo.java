package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id @GeneratedValue
    public Integer id;
    public String title;
    
    public Todo(){

    } 

    public Todo(String title) {
        this.title = title;
    }

}
