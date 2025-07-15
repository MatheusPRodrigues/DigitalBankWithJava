package service;

import exception.ValueException;
import model.Account;
import model.Client;
import model.SavingsAccount;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/// Deposito, saque e transferencia precisam verificar se o valor inserido é negativo ou 0
/// Não pode-se transferir ou sacar mais do que se arrecada
///

public class AccountService {

    private static final Scanner scanner = new Scanner(System.in);

    private static void valuesValidation(double value) {
        if (value < 0) throw new ValueException("Valor negativo!");
        if (value == 0) throw new ValueException("Valor igual a zero!");
    }

    private static void saldValidation(Account account, double withdraw) {
        if (account.getSald() < withdraw) throw new ValueException("Saldo insuficiente!");
    }

    private static Client searchClient(List<Client> clients, String cpf){
        for (Client c : clients) {
            if (c.getCpf().equals(cpf)) return c;
        }

        return null;
    }

    private static boolean checkActualClientCPF(Client currentClient, String cpf) {
        if (currentClient.getCpf().equals(cpf)) {
            System.out.println("Este é o seu CPF, insira outro!");
            return true;
        } else {
            return false;
        }
    }

    public static void deposit(Account account) {
        if (account.getClass().getSimpleName().equals("SavingsAccount")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;

            if (savingsAccount.getActionsToday() == savingsAccount.getDAILY_ACTIONS()) {
                System.out.println("Limite de ações diárias atingindo!");
                return;
            }
        }

        double deposit;

        do {
            System.out.println("Insira o valor de depósito: ");

            try {
                if (scanner.hasNextDouble()) {
                    deposit = scanner.nextDouble();
                    valuesValidation(deposit);
                    break;
                } else {
                    throw new ValueException("Insira um valor númerico!");
                }
            } catch (ValueException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        } while (true);

        System.out.println("Depóstio de R$" + String.format("%.2f",deposit) + " realizado!");
        account.deposit(deposit);
    }

    public static double withdraw(Account account) {
        if (account.getClass().getSimpleName().equals("SavingsAccount")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;

            if (savingsAccount.getActionsToday() == savingsAccount.getDAILY_ACTIONS()) {
                System.out.println("Limite de ações diárias atingindo!");
                return 0;
            }
        }

        double witdraw;

        do {
            System.out.println("Insira o valor de depósito: ");

            try {
                if (scanner.hasNextDouble()) {
                    witdraw = scanner.nextDouble();
                    saldValidation(account, witdraw);
                    valuesValidation(witdraw);
                    break;
                } else {
                    throw new ValueException("Insira um valor númerico!");
                }
            } catch (ValueException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                if (e.getMessage().equals("Saldo insuficiente!")) return 0;
            }
        } while (true);

        return witdraw;
    }

    public static void transfer(Account account, List<Client> clientList, Client currentClient) {
        double transferenceValue = withdraw(account);
        if (transferenceValue == 0) return;

        scanner.nextLine();

        String cpf;
        do {
            System.out.println("Digite o CPF do destinatario: ");
            cpf = scanner.nextLine();
        } while (!ClientServices.cpfValidation(cpf, clientList, 0) && checkActualClientCPF(currentClient, cpf));


        Client destinatary = searchClient(clientList, cpf);

        if (destinatary== null) {
            System.out.println("Não há nenhum cliente com esse cpf!");
            return;
        }

        int option;
        do {
            System.out.println("Enviando para: " + destinatary.getName());
            System.out.println("Informe a conta em que deseja transferir o dinheiro: ");
            System.out.println("[1] - Conta corrente");
            System.out.println("[2] - Conta poupança");
            System.out.println("[0] - Voltar");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                scanner.nextLine();
                option = -1;
            }

            switch (option) {
                case 1 -> {
                    account.transfer(transferenceValue, destinatary.getCheckingAccount());
                    System.out.println("Transferência realizada com sucesso!");
                    return;
                }
                case 2 ->{
                    account.transfer(transferenceValue, destinatary.getSavingsAccount());
                    System.out.println("Transferência realizada com sucesso!");
                    return;
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Entrada inválida! Tente novamente");
            }
        }while (true);
    }

}
