package model;

public final class SavingsAccount extends Account {

    private int DAILY_ACTIONS = 3;
    private int actionsToday = 0;


    @Override
    public void showInfo() {
        System.out.println("||====================||");
        System.out.println("Agência: " + this.agency);
        System.out.println("Nº - " + this.agencyNumber);
        System.out.println("Saldo: " + String.format("%.2f", this.sald));
        System.out.println("Limite diário: " + this.DAILY_ACTIONS);
        System.out.println("Ações realizadas até o momento: " + this.actionsToday);
        System.out.println("||====================||");
    }

    @Override
    public void deposit(double value) {
        this.sald += value;
        this.actionsToday++;
    }

    @Override
    public void transfer(double value, Account account) {
        withdraw(value);
        account.deposit(value);
    }

    @Override
    public void withdraw(double value) {
        this.sald -= value;
        this.actionsToday++;
    }

    public int getDAILY_ACTIONS() {
        return DAILY_ACTIONS;
    }

    public int getActionsToday() {
        return actionsToday;
    }
}
