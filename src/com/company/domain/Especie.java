package com.company.domain;

public class Especie {
    private String nome;
    private Animal[] animais = new Animal[10];

    public Especie(String nome) {
        this.nome = nome;
    }
}
