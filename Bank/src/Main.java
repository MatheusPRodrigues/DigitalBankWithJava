import dao.ClienteDao;
import model.Bank;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        Bank bank = new Bank("Santander");
        int option = 0;

        do {
            System.out.println("[1] - Informações do Banco");
            System.out.println("[2] - Cadastrar-se");
            System.out.println("[3] - Logar");
            System.out.println("[0] - Sair");
            option = scanner.nextInt();



            switch (option) {
                case 1 -> bank.bankInfos();
                case 2 -> ClienteDao.signUp(bank, clients);
                case 0 -> {
                    System.out.println("Sistema encerrado!");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida! Tente novamente!");
            }
        } while (true);
    }
}