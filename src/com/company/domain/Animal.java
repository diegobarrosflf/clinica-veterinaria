package com.company.domain;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private String idade;
    private String sexo;
    private Especie especie;
    private Cliente dono;
    private List<Consulta> historico = new ArrayList<>();

    public Animal(String nome, String idade, String sexo, Especie especie, Cliente dono) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.especie = especie;
        this.dono = dono;
    }

    public boolean addConsultaAoHistorico(Consulta consulta) {
        return historico.add(consulta);
    }
}
