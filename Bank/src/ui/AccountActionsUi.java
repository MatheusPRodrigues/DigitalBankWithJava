package ui;

import model.Account;
import model.Client;
import service.AccountService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AccountActionsUi {

    private static final Scanner scanner = new Scanner(System.in);

    private static String welcomeMessage(Account account) {
        if (account.getClass().getSimpleName().equals("CheckingAccount")) return "Conta corrente";

        return "Conta poupança";
    }

    public static void accountUi(Account account, List<Client> clients, Client currentClient) {
        int option;
        do {
            System.out.println("====== " + welcomeMessage(account) + " ======");
            System.out.println("[1] - Informações da conta");
            System.out.println("[2] - Depósito");
            System.out.println("[3] - Transferência");
            System.out.println("[4] - Saque");
            System.out.println("[0] - Voltar");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                option = -1;
                scanner.nextLine();
            }

            switch (option) {
                case 1 -> account.showInfo();
                case 2 -> AccountService.deposit(account);
                case 3 -> AccountService.transfer(account, clients, currentClient);
                case 4 -> {
                    double value = AccountService.withdraw(account, true);
                    if (value > 0) account.withdraw(value);
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Entrada inválida! Tente novamente!");
            }
        }while (true);
    }

}
