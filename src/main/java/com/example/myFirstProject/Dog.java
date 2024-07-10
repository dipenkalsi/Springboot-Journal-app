package com.example.myFirstProject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Dog {
    public String name = "Tommy";

    public String getName(){
        return this.name;
    }

}
