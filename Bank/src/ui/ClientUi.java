package ui;

import model.Client;

import java.util.Scanner;

public class ClientUi {

    private static final Scanner scanner = new Scanner(System.in);

    public static void clientInterface(Client client) {
        int option;
        do {
            System.out.println("====== Bem-vindo Sr(a) " + client.getName() + "! ======");
            System.out.println("[1] - Conta corrente");
            System.out.println("[2] - Conta poupança");
            System.out.println("[0] - Sair");
            option = scanner.nextInt();

            switch (option) {
                case 0 -> {
                    System.out.println("Voltando para o menu principal");
                    return;
                }
                default -> System.out.println("Entrada inválida! Tente novamente!");
            }
        } while (true);
    }

}
