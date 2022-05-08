package org.acme.example;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String nome) {
        return "hello " + nome;
    }
    
}
