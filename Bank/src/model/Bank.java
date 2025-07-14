package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final String name;
    private List<Client> clients;

    public Bank(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClienteInBank(Client client) {
        this.clients.add(client);
    }

    public void bankInfos() {
        System.out.println("======= Seja Bem-Vindo! =======");
        System.out.println("Banco: " + this.name);
        System.out.println("Quantidade de clientes: " + this.clients.size());
        System.out.println("===============================");
    }

}
