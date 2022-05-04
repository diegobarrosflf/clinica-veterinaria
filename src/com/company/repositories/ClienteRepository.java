package com.company.repositories;

import com.company.domain.Cliente;

import java.util.Objects;

/**
 * Classe responsável por realizar as operações de CRUD para entidade Cliente.
 *
 * @author Diego Barros
 **/

public class ClienteRepository {

    private Cliente[] clienteDB = new Cliente[100];

    public ClienteRepository() {
        populaBase();
    }

    /**
     * Método responsável por adicionar um cliente a base de dados.
     *
     * @param novoCliente
     * @return boolean
     */
    public boolean addCliente(Cliente novoCliente) {
        for (int i = 0; i < clienteDB.length; i++) {
            if (clienteDB[i] == null) {
                clienteDB[i] = novoCliente;
                System.out.println("cliente adicionado com sucesso.");
                return true;
            }
        }
        System.out.println("cliente não adicionado, espaço insuficiente.");
        return false;
    }

    //Research
    public Cliente[] findByName(String nomePesquisado) {
        nomePesquisado = nomePesquisado.toLowerCase();
        Cliente[] listaDeClientes = new Cliente[10];
        int aux = 0;
        for (Cliente cliente : clienteDB) {
            if (cliente != null) {
                String nomeCliente = cliente.getNome().toLowerCase();
                if (nomeCliente.contains(nomePesquisado)) {
                    listaDeClientes[aux] = cliente;
                    aux++;
                }
            }
        }
        if (listaDeClientes[0] != null) {
            System.out.println("cliente encontrado");
            return listaDeClientes;
        } else {
            System.out.println("cliente não encontrado");
            return null;
        }
    }

    public Cliente findByDocumento(String documento) {
        for (Cliente cliente : clienteDB) {
            if (cliente != null && documento.equals(cliente.getDocumento())) {
                System.out.println("cliente encontrado");
                return cliente;
            }
        }
        System.out.println("cliente não encontrado");
        return null;
    }

    //Update
    public boolean updateCliente(Cliente clienteAtualizado, String documento) {
        //encontrar cliente na base pelo documento
        Cliente clienteCorrente = findByDocumento(documento);
        if (Objects.isNull(clienteCorrente)) {
            System.out.println("Cliente não encontrado para atualização");
            return false;
        }
        String novoNome = clienteAtualizado.getNome();
        String novoEndereco = clienteAtualizado.getEndereco();
        String novoDocumento = clienteAtualizado.getDocumento();
        String novoTelefone = clienteAtualizado.getTelefone();
        String novoEmail = clienteAtualizado.getEmail();

        //verificar quais campos preciso atualizar & atualiza
        if (isValidString(novoNome)) {
            clienteCorrente.setNome(novoNome);
        }
        if (isValidString(novoEndereco)) {
            clienteCorrente.setEndereco(novoEndereco);
        }
        if (novoDocumento != null && !novoDocumento.isBlank()) {
            clienteCorrente.setDocumento(novoDocumento);
        }
        if (novoTelefone != null && !novoTelefone.isBlank()) {
            clienteCorrente.setTelefone(novoTelefone);
        }
        if (novoEmail != null && !novoEmail.isBlank()) {
            clienteCorrente.setEmail(novoEmail);
        }
        System.out.println("Cliente atualizado com sucesso.");
        return true;
    }

    //Delete
    public boolean deleteByDocumento(String documento) {
        for (int i = 0; i < clienteDB.length; i++) {
            if ((clienteDB[i] != null) && clienteDB[i].getDocumento().equals(documento)) {
                clienteDB[i] = null;
                System.out.println("Cliente deletado com sucesso.");
                return true;
            }
        }
        System.out.println("Cliente não encontrado.");
        return false;
    }

    private void populaBase() {
        Cliente cliente1 = new Cliente("José da Silva", "Rua A, 12", "12345", "(85) 98743-1233", "jose@gmail.com");
        Cliente cliente2 = new Cliente("João de Araújo", "Rua B, 122", "98876", "(85) 97733-4365", "ojuara@gmail.com");
        Cliente cliente3 = new Cliente("Maria Helena de Silva", "Rua C, 54", "92846", "(85) 94376-7676", "maria@gmail.com");

        clienteDB[0] = cliente1;
        clienteDB[1] = cliente2;
        clienteDB[2] = cliente3;
    }

    private boolean isValidString(String value) {
        return value != null && !value.isBlank();
    }
}
