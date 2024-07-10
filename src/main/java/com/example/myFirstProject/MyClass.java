package com.example.myFirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {
    @GetMapping("myEndpoint") //Defining an endpoint on the API. So this defines "localhost:8080/myEndpoint"
    public String sayHello(){
        return "HELLO";
    }
}
