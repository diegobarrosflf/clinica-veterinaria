package com.company.domain;

import java.util.ArrayList;
import java.util.List;

public class Especie {

    private String nome;
    private List<Animal> animais = new ArrayList<>();

    public Especie(String nome) {
        this.nome = nome;
    }

    public boolean addAnimal(Animal animal) {
        return animais.add(animal);
    }
}
