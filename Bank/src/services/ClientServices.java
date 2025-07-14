package services;

import model.Bank;
import model.Client;

import java.util.List;

public class ClientServices {

    private static boolean cpfCheck(String cpf, List<Client> clients) {
        for (Client c : clients) {
            if (c.getCpf().equals(cpf)) {
                return true;
            }
        }

        return false;
    }

    public static boolean cpfValidation(String cpf, List<Client> clients, int typeOperation) {
        if (!cpf.matches("^\\d+$")) {
            System.out.println("CPF inválido! Tente novamente!");
            return false;
        }
        if (typeOperation == 1) {
            if (cpfCheck(cpf, clients)) {
                System.out.println("CPF já cadastrado! Faça o login!");
                return false;
            }
        }

        return cpf.length() == 11;
    }

    public static boolean nameValidation(String name) {
        if (name.matches(".*\\\\d.*")) return false;

        return !(name.isEmpty() | name.isBlank());
    }

    public static boolean ageValidation(int age) {
        if (age < 18) {
            System.out.println("Menores de 18 anos não podem se cadastrar!");
            return false;
        }

        return true;
    }

    public static boolean passValidation(String pass) {
        if (pass.matches(".*\\s.*")) {
            System.out.println("A senha não pode conter espaços!");
            return false;
        }

        if (pass.isBlank()) {
            System.out.println("Insira uma senha válida!");
            return false;
        }

        if (pass.length() < 6 | pass.length() > 8) {
            System.out.println("Senha inválida! Respeite o tamanho da senha!");
            return false;
        }

        return true;
    }

    public static Client realizeLogIn(List<Client> clients, String cpf, String pass) {
        for (Client c : clients) {
            if (c.getCpf().equals(cpf) && c.getPassword().equals(pass)) return c;
        }

        return null;
    }

}
