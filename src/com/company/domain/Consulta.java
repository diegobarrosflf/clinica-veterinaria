package com.company.domain;

public class Consulta extends EntidadeBase {
    private String data;
    private String endereco;
    private String procedimento;
    private Veterinario veterinario;
    private Animal animal;

    public Consulta(String data, String endereco, String procedimento, Veterinario veterinario, Animal animal) {
        this.data = data;
        this.endereco = endereco;
        this.procedimento = procedimento;
        this.veterinario = veterinario;
        this.animal = animal;
    }
}
