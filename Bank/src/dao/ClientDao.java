package dao;

import model.Bank;
import model.Client;
import service.ClientServices;

import java.util.Scanner;

public class ClientDao {
    private static final Scanner scanner = new Scanner(System.in);

    public static void signUp(Bank bank) {
        // *** CPF insertion ***
        String cpf;
        do {
            System.out.println("Digite seu CPF (somente números): ");
            cpf = scanner.nextLine();

        } while (!ClientServices.cpfValidation(cpf, bank.getClients(), 1));

        // *** Name insertion ***
        String name;
        do {
            System.out.println("Insira seu nome: ");
            name = scanner.nextLine();

            if (ClientServices.nameValidation(name)) {
                break;
            } else {
                System.out.println("Nome Inválido! Tente novamente!");
            }
        } while (true);

        // *** Age insertion ***
        int age;
        do {
            System.out.println("Insira sua idade: ");
            String input = scanner.nextLine();

            try {
                age = Integer.parseInt(input);
                if (ClientServices.ageValidation(age)) {
                    break;
                } else {
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida! Tente novamente!");
            }
        } while (true);

        // *** Pass insertion ***
        String pass;
        do {
            System.out.println("Insira sua senha (entre 6 a 8 caracteres):");
            pass = scanner.nextLine();

        } while (!ClientServices.passValidation(pass));

        Client client = new Client(cpf, name, age, pass);

        bank.addClienteInBank(client);

        System.out.println("Usuário cadastrado com sucesso!\nPressione 'Enter' tecla para continuar...");
        scanner.nextLine();
    }

}
