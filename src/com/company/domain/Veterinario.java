package com.company.domain;

import java.util.ArrayList;
import java.util.List;

public class Veterinario extends EntidadeBase {
    private String nome;
    private String CRMV;
    private List<Consulta> consultas = new ArrayList<>();
    
    public Veterinario( String nome, String CRMV) {
        this.nome = nome;
        this.CRMV = CRMV;
    }

    public boolean addConsulta(Consulta consulta) {
        return consultas.add(consulta);
    }
}
