package ui;

import model.Bank;
import model.Client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientUi {

    private static final Scanner scanner = new Scanner(System.in);

    public static void clientInterface(Client client, Bank bank) {
        int option;
        do {
            System.out.println("====== Bem-vindo Sr(a) " + client.getName() + "! ======");
            System.out.println("[1] - Conta corrente");
            System.out.println("[2] - Conta poupança");
            System.out.println("[0] - Sair");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                option = -1;
                scanner.nextLine();
            }

            switch (option) {
                case 1 -> AccountActionsUi.accountUi(client.getCheckingAccount(), bank.getClients(), client);
                case 2 -> AccountActionsUi.accountUi(client.getSavingsAccount(), bank.getClients(), client);
                case 0 -> {
                    System.out.println("Voltando para o menu principal");
                    return;
                }
                default -> System.out.println("Entrada inválida! Tente novamente!");
            }
        } while (true);
    }

}
