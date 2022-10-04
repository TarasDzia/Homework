package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class Pet{
    List<Animal> animals;

    @Autowired
    public Pet(List<Animal> animals) {
        this.animals = animals;
    }

    public void pritnPets() {
        animals.forEach(a -> System.out.println(a.getClass().getSimpleName()));
    }
}
