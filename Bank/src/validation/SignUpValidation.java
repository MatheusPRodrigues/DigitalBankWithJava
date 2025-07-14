package validation;

import model.Client;

import java.util.List;

public class SignUpValidation {

    private static boolean cpfCheck(String cpf, List<Client> clients) {
        for (Client c : clients) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("CPF já cadastrado!");
                return false;
            }
        }

        return true;
    }

    public static boolean cpfValidation(String cpf, List<Client> clients) {
        if (!cpf.matches("^\\d+$")) return false;
        if (!cpfCheck(cpf, clients)) return false;

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

}
