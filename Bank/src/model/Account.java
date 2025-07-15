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

    public double getSald() {
        return sald;
    }

    public abstract void showInfo();

    public abstract void deposit(double value);

    public abstract void transfer(double value, Account account);

    public abstract void withdraw(double value);
}
