package model;

public final class CheckingAccount extends Account {

    @Override
    public void showInfo() {
        System.out.println("||====================||");
        System.out.println("Agência: " + this.agency);
        System.out.println("Nº - " + this.agencyNumber);
        System.out.println("Saldo: " + String.format("%.2f", this.sald));
        System.out.println("||====================||");
    }

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
