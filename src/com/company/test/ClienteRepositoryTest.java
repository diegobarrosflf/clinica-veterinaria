package com.company.test;

import com.company.domain.Cliente;
import com.company.repositories.ClienteRepository;
import com.company.repositories.Repository;

public class ClienteRepositoryTest {
    public static void main(String[] args) {
        Repository clienteRepository = new ClienteRepository();

        Cliente cliente1 = new Cliente("Diego Barros", "Rua XPTO #12", "321.654.987-89", "3216-98745", "diego@email.com");
        Cliente cliente2 = new Cliente("Jose Antonio", "Rua XPTO #1212", "654.987.321-65","3216-98745", "jose@email.com");
        Cliente cliente3 = new Cliente("Maria da Silva", "Rua XPTO #121212", "951.657.984-32","3216-98745", "maria@email.com");

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        /*Cliente diego = clienteRepository.findByDocumento("321.654.987-89");
        Cliente antonio = clienteRepository.findByDocumento("654.987.321-65");
        Cliente maria = clienteRepository.findByDocumento("951.657.984-32");

        System.out.println(diego);
        System.out.println(antonio);
        System.out.println(maria);*/

        System.out.println(cliente1.equals(cliente2));
        System.out.println(cliente1);
        System.out.println(cliente2);

        cliente2.setDocumento(cliente1.getDocumento());

        System.out.println(cliente1.equals(cliente2));
        System.out.println(cliente1);
        System.out.println(cliente2);


    }
}
