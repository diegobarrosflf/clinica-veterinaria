package com.company.domain;

public class Animal {
    private String nome;
    private String idade;
    private String sexo;
    private Especie especie;
    private Cliente dono;
    private Consulta[] historico = new Consulta[100];

    public Animal(String nome, String idade, String sexo, Especie especie, Cliente dono) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.especie = especie;
        this.dono = dono;
    }

    public boolean addConsultaAoHistorico(Consulta consulta) {
        for(int i = 0; i< historico.length; i++) {
            if (historico[i] == null) {
                historico[i] = consulta;
                System.out.println("consulta adicionada com sucesso.");
                return true;
            }
        }
        System.out.println("consulta não adicionada, espaço insuficinete...");
        return false;
    }
}
