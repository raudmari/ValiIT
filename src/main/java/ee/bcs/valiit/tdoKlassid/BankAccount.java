package ee.bcs.valiit.tdoKlassid;

public class BankAccount {
    private String owner;
    private String iban;
    private double balance;
    private boolean accountStatus;

/*    public BankAccount(String owner, String iban, double balance, boolean locked) {
        this.owner = owner;
        this.iban = iban;
        this.balance = balance;
        this.accountStatus = locked;
    }*/

    public double depositMoney(double balance, double amount){
        balance = balance + amount;
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
