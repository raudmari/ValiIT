package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson4;
import ee.bcs.valiit.tdoKlassid.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    // http://localhost:8080/bank/createAccount
    @PostMapping("bank/createAccount")
    public void createAccount(@RequestBody Bank request) {
        accountBalanceMap.put(request.getIban(), request.getBalance());
    }

    // http://localhost:8080/bank/getBalance/
    @GetMapping("bank/getBalance/{Nr}")
    public String getBalance(@PathVariable("Nr") String iban) {
        if (accountBalanceMap.get(iban) == null) {
            return "No account. Make new account.";
        } else {
            return "Balance is " + accountBalanceMap.get(iban);
        }
    }

    // http://localhost:8080/bank/depositMoney/
    @GetMapping("bank/depositMoney/{Nr}/{amount}")
    public String depositMoney(@PathVariable("Nr") String iban, @PathVariable("amount") double amount) {
        if (accountBalanceMap.get(iban) == null) {
            return "No account. Make new account.";
        } else if(amount < 1 ){
            return "Nothing to deposit";
        } else {
            double balance = accountBalanceMap.get(iban) + amount;
            accountBalanceMap.put(iban, balance);
            return iban + " new balance is EUR " + accountBalanceMap.get(iban);
        }
    }

    // http://localhost:8080/bank/withdrawMoney/
    @GetMapping("bank/withdrawMoney/{Nr}/{amount}")
    public String withdrawMoney(@PathVariable("Nr") String iban, @PathVariable("amount") double amount) {
        if (accountBalanceMap.get(iban) == null) {
            return "No account. Make new account.";
        } else if(accountBalanceMap.get(iban) < amount){
            return "Not enough funds";
        } else {
            double balance = accountBalanceMap.get(iban) - amount;
            accountBalanceMap.put(iban, balance);
            return iban + " new balance is EUR " + accountBalanceMap.get(iban);
        }
    }

    // http://localhost:8080/bank/transferMoney/
    @GetMapping("bank/transferMoney/{NrFrom}/{amount}/{NrTo}")
    public static String transferMoney(@PathVariable("NrFrom") String accountWithdraw,
                                       @PathVariable("amount") double transferAmount,
                                       @PathVariable("NrTo") String accountDeposit) {
        if (accountBalanceMap.get(accountWithdraw) == null && accountBalanceMap.get(accountWithdraw) == null) {
            return "No account available";
        } else if (accountBalanceMap.get(accountWithdraw) < transferAmount) {
            return "Not enough funds";
        } else {
            double withdrawMoney = accountBalanceMap.get(accountWithdraw) - transferAmount;
            accountBalanceMap.put(accountWithdraw, withdrawMoney);
            double depositMoney = accountBalanceMap.get(accountDeposit) + transferAmount;
            accountBalanceMap.put(accountDeposit, depositMoney);
            return accountWithdraw + " new balance after transfer is EUR " + accountBalanceMap.get(accountWithdraw) + "." +
                    accountDeposit + " new balance after transfer is EUR " + accountBalanceMap.get(accountDeposit)+ ".";
        }
    }






}
