package com.company.repositories;

import com.company.domain.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe responsável por realizar as operações de CRUD para entidade Cliente.
 *
 * @author Diego Barros
 **/

public class ClienteRepository {

    private List<Cliente> clienteDB = new ArrayList<>();

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

        boolean result = clienteDB.add(novoCliente);
        if (result) {
            System.out.println("cliente adicionado com sucesso.");
            return result;
        } else {
            System.out.println("erro ao adicionar um cliente.");
            return result;
        }
    }

    //Research
    public List<Cliente> findByName(String nome) {
        nome = nome.toLowerCase();
        List<Cliente> resultado = new ArrayList<>();

        for (Cliente cliente : clienteDB) {
            String nomeCliente = cliente.getNome().toLowerCase();
            if (nomeCliente.contains(nome)) {
                resultado.add(cliente);
            }
        }
        if (resultado.isEmpty()) {
            System.out.println("cliente não encontrado");
            return new ArrayList<>();
        } else {
            System.out.println("cliente encontrado");
            return resultado;
        }
    }

    public Cliente findByDocumento(String documento) {
        for (Cliente cliente : clienteDB) {
            if (documento.equalsIgnoreCase(cliente.getDocumento())) {
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
        if (isValidString(novoDocumento)) {
            clienteCorrente.setDocumento(novoDocumento);
        }
        if (isValidString(novoTelefone)) {
            clienteCorrente.setTelefone(novoTelefone);
        }
        if (isValidString(novoEmail)) {
            clienteCorrente.setEmail(novoEmail);
        }
        System.out.println("Cliente atualizado com sucesso.");
        return true;
    }

    //Delete
    public boolean deleteByDocumento(String documento) {
        Cliente cliente = findByDocumento(documento);
        return clienteDB.remove(cliente);
    }

    private void populaBase() {
        Cliente cliente1 = new Cliente("José da Silva", "Rua A, 12", "12345", "(85) 98743-1233", "jose@gmail.com");
        Cliente cliente2 = new Cliente("João de Araújo", "Rua B, 122", "98876", "(85) 97733-4365", "ojuara@gmail.com");
        Cliente cliente3 = new Cliente("Maria Helena de Silva", "Rua C, 54", "92846", "(85) 94376-7676", "maria@gmail.com");

        clienteDB.add(cliente1);
        clienteDB.add(cliente2);
        clienteDB.add(cliente3);
    }

    private boolean isValidString(String value) {
        return value != null && !value.isBlank();
    }
}
