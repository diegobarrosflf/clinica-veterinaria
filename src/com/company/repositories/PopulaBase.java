package com.company.repositories;

import com.company.domain.Cliente;

import java.util.List;

public class PopulaBase {

    private void populaBaseCliente(List<Cliente> clienteDB) {
        Cliente cliente1 = new Cliente("José da Silva", "Rua A, 12", "12345", "(85) 98743-1233", "jose@gmail.com");
        Cliente cliente2 = new Cliente("João de Araújo", "Rua B, 122", "98876", "(85) 97733-4365", "ojuara@gmail.com");
        Cliente cliente3 = new Cliente("Maria Helena de Silva", "Rua C, 54", "92846", "(85) 94376-7676", "maria@gmail.com");

        clienteDB.add(cliente1);
        clienteDB.add(cliente2);
        clienteDB.add(cliente3);
    }

}
