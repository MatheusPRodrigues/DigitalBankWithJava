package model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String cpf;
    private String name;
    private int age;
    private String password;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;

    public Client(String cpf, String name, int age, String password) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.password = password;
        this.checkingAccount = new CheckingAccount();
        this.savingsAccount = new SavingsAccount();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
