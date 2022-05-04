package com.company.domain;

import java.util.Objects;

public class Cliente {
    private String nome;
    private String endereco;
    private String documento;
    private String telefone;
    private String email;
    private Animal[] pets = new Animal[10];

    public Cliente(String nome, String endereco, String documento, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean addPet(Animal novoPet) {
        for(int i = 0; i< pets.length; i++) {
           if (pets[i] == null) {
               pets[i] = novoPet;
               System.out.println("pet adicionado com sucesso.");
               return true;
           }
        }
        System.out.println("pet não adicionado, espaço insuficinete...");
        return false;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(documento, cliente.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
