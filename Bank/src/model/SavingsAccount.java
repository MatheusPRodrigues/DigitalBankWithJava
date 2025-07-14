package model;

public final class SavingsAccount extends Account {

    @Override
    public void deposit(double value) {
        this.sald += value;
    }

    @Override
    public void transfer(double value, Account account) {
        withdraw(value);
        account.deposit(value);
    }

    @Override
    public void withdraw(double value) {
        this.sald -= value;
    }
}
