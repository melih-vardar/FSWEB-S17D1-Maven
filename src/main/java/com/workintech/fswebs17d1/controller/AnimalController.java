package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/workintech/animal")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal find(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping("/workintech/animal")
    public Animal create(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal update(@PathVariable int id, @RequestBody String name){
        Animal animal = animals.get(id);
        animal.setName(name);
        return animal;
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal delete(@PathVariable int id){
        Animal animal = animals.get(id);
        animals.remove(animal.getId(), animal);
        return animal;
    }



}
