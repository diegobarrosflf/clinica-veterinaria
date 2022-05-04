package com.company;

import com.company.domain.Cliente;
import com.company.repositories.ClienteRepository;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static Scanner teclado = new Scanner(System.in);
    private static ClienteRepository clienteRepository = new ClienteRepository();
    private static boolean controle = true;
    private static int menu = -1;

    public static void main(String[] args) {

        while (controle) {

                opcoesMenu();
                coletarOpcaoMenu();

            switch (menu) {
                case 0:
                    sair();
                    break;
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    pesquisarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    deletarCliente();
                    break;
            }
        }

    }

    private static void coletarOpcaoMenu() {
        boolean aux = true;
        while (aux) {
            try {
                menu = teclado.nextInt();
                teclado.nextLine();
                aux = false;
            } catch (InputMismatchException exp) {
                System.out.println("Valor inválido, digite um número válido");
                teclado.nextLine();
            }
        }
    }

    private static void opcoesMenu() {
        System.out.println("<---- Clínica veterinária --->");
        System.out.println("Escolha uma das opções");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Pesquisar cliente");
        System.out.println("3. Atualizar cliente");
        System.out.println("4. Deletar cliente");

        System.out.println("0. sair");
    }

    private static void deletarCliente() {
        System.out.println("<----Deletar Cliente----->");
        System.out.println("Digite o documento do cliente a ser deletado");
        String documento = teclado.nextLine();
        clienteRepository.deleteByDocumento(documento);

        System.out.println("Aperte enter para retorna.");
        teclado.nextLine();
    }

    private static void atualizarCliente() {
        System.out.println("<---Atualizar Cliente--->");
        System.out.println("OBS: Caso não deseja alterar um campo aperter enter e vá para o próximo.");
        System.out.println("digite o documento do cliente a ser atualizado");
        String documentoAtual = teclado.nextLine();

        System.out.println("Digite o novo nome do cliente");
        String nomeNovo = teclado.nextLine();

        System.out.println("Digite o novo endereco ");
        String enderecoNovo = teclado.nextLine();

        System.out.println("Digite o novo documento");
        String documentoNovo = teclado.nextLine();

        System.out.println("Digite o novo telefone");
        String telefoneNovo = teclado.nextLine();

        System.out.println("Digite o novo email");
        String emailNovo = teclado.nextLine();

        Cliente clienteAtualizado = new Cliente(nomeNovo, enderecoNovo, documentoNovo, telefoneNovo, emailNovo);

        clienteRepository.updateCliente(clienteAtualizado, documentoAtual);
        System.out.println("Aperte enter para retorna.");
        teclado.nextLine();
    }


    private static void cadastrarCliente() {

        System.out.println("<---- Cadastrar Cliente---->");

        System.out.println("Digite o nome do cliente");
        String nome = teclado.nextLine();

        System.out.println("Digite o endereco ");
        String endereco = teclado.nextLine();

        System.out.println("Digite um documento");
        String documento = teclado.nextLine();

        System.out.println("Digite telefone");
        String telefone = teclado.nextLine();

        System.out.println("Digite email");
        String email = teclado.nextLine();

        Cliente novoCliente = new Cliente(nome, endereco, documento, telefone, email);
        clienteRepository.addCliente(novoCliente);

        System.out.println("Aperte enter para retorna.");
        teclado.nextLine();
    }

    private static void pesquisarCliente() {
        System.out.println("<----Pesquisa cliente---->");

        System.out.println("Digite o nome do cliente.");
        String nome = teclado.nextLine();

        Cliente[] clientes = clienteRepository.findByName(nome);

        if (Objects.nonNull(clientes)) {
            for(Cliente cliente : clientes) {
                if (cliente != null) {
                    System.out.println(cliente);
                }
            }
        }

        System.out.println("Aperte enter para retorna.");
        teclado.nextLine();
    }

    private static void sair() {
        System.out.println("Encerrando sistemas.");
        teclado.close();
        Main.controle = false;
    }
}
