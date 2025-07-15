package ui;

import model.Bank;
import model.Client;
import service.ClientServices;

import java.util.Scanner;

public class LogInUi {

    private static final Scanner scanner = new Scanner(System.in);

    public static void LogInInterface(Bank bank) {
        // *** CPF insertion ***
        String cpf;
        do {
            System.out.println("Digite seu CPF (somente números): ");
            cpf = scanner.nextLine();

        } while (!ClientServices.cpfValidation(cpf, bank.getClients(), 0));

        // *** Pass insertion ***
        String pass;
        do {
            System.out.println("Insira sua senha (entre 6 a 8 caracteres):");
            pass = scanner.nextLine();

        } while (!ClientServices.passValidation(pass));

        Client client = ClientServices.realizeLogIn(bank.getClients(), cpf, pass);

        if (client == null) {
            System.out.println("CPF ou Senha inválidos! Tente novamente!");
        } else {
            ClientUi.clientInterface(client, bank);
        }
    }

}
