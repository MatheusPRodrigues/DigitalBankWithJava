package dao;

import model.Bank;
import model.Client;
import validation.SignUpValidation;

import java.util.List;
import java.util.Scanner;

public class ClienteDao {
    private static final Scanner scanner = new Scanner(System.in);

    public static void signUp(Bank bank, List<Client> clients) {
        // CPF insertion
        String cpf = "";
        do {
            System.out.println("Digite seu CPF: ");
            cpf = scanner.nextLine();

            if (SignUpValidation.cpfValidation(cpf, clients)) {
                break;
            } else {
                System.out.println("CPF Inválido! Tente novamente!");
            }
        } while (true);

        // Name insertion
        String name;
        do {
            System.out.println("Insira seu nome: ");
            name = scanner.nextLine();

            if (SignUpValidation.nameValidation(name)) {
                break;
            } else {
                System.out.println("Nome Inválido! Tente novamente!");
            }
        } while (true);

        // Age insertion
        int age = 0;
        do {
            System.out.println("Insira sua idade: ");
            String input = scanner.nextLine();

            try {
                age = Integer.parseInt(input);
                if (SignUpValidation.ageValidation(age)) {
                    break;
                } else {
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida! Tente novamente!");
            }
        } while (true);

        clients.add(new Client(cpf, name, age));
        bank.addClienteInBank(new Client(cpf, name, age));

        System.out.println("Usuário cadastrado com sucesso!\nPressione 'Enter' tecla para continuar...");
        scanner.nextLine();
    }

}
