package ee.bcs.valiit.controller;

import ee.bcs.valiit.tdoKlassid.BankAccount;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankAccountController {
    private static Map<String, BankAccount> accountMap = new HashMap<>();

    // http://localhost:8080/bankAccount/createAccount
    @PostMapping("bankAccount/createAccount")
    public void createAccount(@RequestBody BankAccount request) {
        accountMap.put(request.getIban(), request);
    }
    // http://localhost:8080/bankAccount/getBalance
    @GetMapping("bankAccount/getBalance/{iban}")
    public String getBalance(@PathVariable("iban") String iban) {
        if (accountMap.get(iban) == null) {
            return "No account. Make new account.";
        } else if(accountMap.get(iban).isAccountStatus() == false){
            return "Account locked! Turn to your account manager";
        } else {
            return "Owner " + accountMap.get(iban).getOwner() + " account " + iban + " balance is EUR " + accountMap.get(iban).getBalance();
        }
    }
    // http://localhost:8080/bankAccount/depositMoney/
    @GetMapping("bankAccount/depositMoney/{iban}/{amount}")
    public String depositMoney(@PathVariable("iban") String iban, @PathVariable("amount") double amount) {
        if (accountMap.get(iban) == null) {
            return "No account. Make new account.";
        }  else if(accountMap.get(iban).isAccountStatus() == false) {
            return "Account locked! Turn to your account manager";
        } else if (amount < 1) {
            return "Nothing to deposit";
        } else {
            double balance = accountMap.get(iban).getBalance() + amount;
            accountMap.get(iban).setBalance(balance);
            return "Owner " + accountMap.get(iban).getOwner() + " account " + iban + " new balance is EUR " + accountMap.get(iban).getBalance();
        }
    }
    // http://localhost:8080/bankAccount/withdrawMoney/
    @GetMapping("bankAccount/withdrawMoney/{iban}/{amount}")
    public String withdrawMoney(@PathVariable("iban") String iban, @PathVariable("amount") double amount) {
        if (accountMap.get(iban) == null) {
            return "No account. Make new account.";
        }  else if(accountMap.get(iban).isAccountStatus() == false) {
            return "Account locked! Turn to your account manager";
        } else if(accountMap.get(iban).getBalance() < amount){
            return "Not enough funds";
        } else {
            double balance = accountMap.get(iban).getBalance() - amount;
            accountMap.get(iban).setBalance(balance);
            return "Owner " + accountMap.get(iban).getOwner() + " account " + iban + " new balance is EUR " + accountMap.get(iban).getBalance();
        }
    }

    // http://localhost:8080/bankAccount/transferMoney/
    @GetMapping("bankAccount/transferMoney/{ibanFrom}/{amount}/{ibanTo}")
    public static String transferMoney(@PathVariable("ibanFrom") String accountWithdraw,
                                       @PathVariable("amount") double transferAmount,
                                       @PathVariable("ibanTo") String accountDeposit) {
        if (accountMap.get(accountWithdraw) == null && accountMap.get(accountWithdraw) == null) {
            return "No account available";
        } else if (accountMap.get(accountWithdraw).getBalance() < transferAmount) {
            return "Not enough funds";
        } else {
            double withdrawMoney = accountMap.get(accountWithdraw).getBalance() - transferAmount;
            accountMap.get(accountWithdraw).setBalance(withdrawMoney);
            double depositMoney = accountMap.get(accountDeposit).getBalance() + transferAmount;
            accountMap.get(accountDeposit).setBalance(depositMoney);
            return "Owner " + accountMap.get(accountWithdraw).getOwner() + " account " + accountWithdraw + " new balance after transfer is EUR " + accountMap.get(accountWithdraw).getBalance() + ".\n" +
                    "Owner " + accountMap.get(accountDeposit).getOwner() + " account " + accountDeposit + " new balance after transfer is EUR " + accountMap.get(accountDeposit).getBalance() + ".";
        }
    }
    @PutMapping("bankAccount/{iban}/lock")
    public String lock(@PathVariable("iban") String iban){
        accountMap.get(iban).setAccountStatus(false);
        return null;
    }

    @PutMapping("bankAccount/{iban}/unlock")
    public String unlock(@PathVariable("iban") String iban){
        accountMap.get(iban).setAccountStatus(true);
        return null;
    }













}
