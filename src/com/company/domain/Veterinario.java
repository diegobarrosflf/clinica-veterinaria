package com.company.domain;

public class Veterinario {
    private String nome;
    private String CRMV;
    private Consulta[] consultas = new Consulta[100];
    
    public Veterinario(String nome, String CRMV) {
        this.nome = nome;
        this.CRMV = CRMV;
    }

    public boolean addConsulta(Consulta consulta) {
        for(int i = 0; i< consultas.length; i++) {
            if (consultas[i] == null) {
                consultas[i] = consulta;
                System.out.println("consulta adicionada com sucesso.");
                return true;
            }
        }
        System.out.println("consulta não adicionada, espaço insuficinete...");
        return false;
    }
}
