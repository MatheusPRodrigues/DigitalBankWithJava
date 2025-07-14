package model;

public sealed abstract class Account permits CheckingAccount, SavingsAccount{

    private static final String STANDARD_AGENCY = "0001";
    private static int SEQUENTIAL = 1;

    protected String agency;
    protected int agencyNumber;
    protected double sald;

    public Account() {
        this.agency = STANDARD_AGENCY;
        this.agencyNumber = SEQUENTIAL++;
        this.sald = 0;
    }

    private String checkAccount() {
        if (this.getClass().getName().equals("CheckingAccount"))
            return "Conta Corrente";

        return "Conta Poupança";
    }

    public void showInfo() {

        System.out.println("===== " + checkAccount() + " =====");
        System.out.println("Agência: " + this.agency);
        System.out.println("Nº - " + this.agencyNumber);
        System.out.println("Saldo: " + String.format("%.2f", this.sald));
        System.out.println("====================");
    }

    public abstract void deposit(double value);

    public abstract void transfer(double value, Account account);

    public abstract void withdraw(double value);
}
