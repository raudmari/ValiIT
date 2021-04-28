package ee.bcs.valiit.tdoKlassid;

import ee.bcs.valiit.hibernate.BankAccountHibernate;

public class AllAccounts {
    private String iban;
    private Double balance;

    public AllAccounts() {
    }

    public AllAccounts(BankAccountHibernate hibernate) {
        this.iban = hibernate.getIban();
        this.balance = hibernate.getBalance();
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
