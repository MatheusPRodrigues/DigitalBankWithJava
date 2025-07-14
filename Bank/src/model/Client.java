package model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String cpf;
    private String name;
    private int age;
    private List<Account> accounts;

    public Client(String cpf, String name, int age) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.accounts = new ArrayList<>(2);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
