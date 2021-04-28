package ee.bcs.valiit.controller;

import ee.bcs.valiit.service.BankAccountService;
import ee.bcs.valiit.tdoKlassid.AllAccounts;
import ee.bcs.valiit.tdoKlassid.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

 /*   private class ObjectRowMapper implements RowMapper<BankAccount> {
        @Override
        public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setOwner(resultSet.getString("owner"));
            bankAccount.setIban(resultSet.getString("iban"));
            bankAccount.setBalance(resultSet.getDouble("balance"));
            bankAccount.setAccountStatus(resultSet.getBoolean("account_status"));
            return bankAccount;
        }
    }
    private static Map<String, BankAccount> accountMap = new HashMap<>();*/

    // http://localhost:8080/bankAccount/createAccount
    @CrossOrigin
    @PostMapping("bankAccount/createAccount")
    public void createAccount(@RequestBody BankAccount request) {
        bankAccountService.createAccount(request);
        // accountMap.put(request.getIban(), request);
    }

    // http://localhost:8080/bankAccount/getBalance
    @CrossOrigin
    @GetMapping("bankAccount/getBalance/{iban}")
    public Double getBalance(@PathVariable("iban") String iban) {
        return bankAccountService.getBalance(iban);

     /*   if (accountMap.get(iban) == null) {
            String sql = "SELECT iban FROM bank_account WHERE iban = :iban";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("iban", iban);
            return "No account. Make new account.";
           } else if (accountMap.get(iban).isAccountStatus() == false) {
        return "Owner " + accountMap.get(iban).getOwner() + " account " + iban + " balance is EUR " + accountMap.get(iban).getBalance();
        }*/
    }

    // http://localhost:8080/bankAccount/depositMoney/
    @CrossOrigin
    @GetMapping("bankAccount/depositMoney/{iban}/{amount}")
    public Double depositMoney(@PathVariable("iban") String iban, @PathVariable("amount") double amount) {
        return bankAccountService.depositMoney(iban, amount);
/*        if (accountMap.get(iban) == null) {
            return "No account. Make new account.";
        } else if (accountMap.get(iban).isAccountStatus() == false) {
            return "Account locked! Turn to your account manager";
        } else if (amount < 1) {
            return "Nothing to deposit";
        } else {
            double balance = accountMap.get(iban).getBalance() + amount;
            accountMap.get(iban).setBalance(balance);
            return "Owner " + accountMap.get(iban).getOwner() + " account " + iban + " new balance is EUR " + accountMap.get(iban).getBalance();
        }*/
    }

    // http://localhost:8080/bankAccount/withdrawMoney/
    @CrossOrigin
    @GetMapping("bankAccount/withdrawMoney/{iban}/{amount}")
    public Double withdrawMoney(@PathVariable("iban") String iban, @PathVariable("amount") double amount) {
        return bankAccountService.withdrawMoney(iban, amount);
   /*     if (accountMap.get(iban) == null) {
            return "No account. Make new account.";
        } else if (accountMap.get(iban).isAccountStatus() == false) {
            return "Account locked! Turn to your account manager";
        } else if (accountMap.get(iban).getBalance() < amount) {
            return "Not enough funds";
        } else {
            double balance = accountMap.get(iban).getBalance() - amount;
            accountMap.get(iban).setBalance(balance);
            return "Owner " + accountMap.get(iban).getOwner() + " account " + iban + " new balance is EUR " + accountMap.get(iban).getBalance();*/
    }

    // http://localhost:8080/bankAccount/transferMoney/
    @CrossOrigin
    @GetMapping("bankAccount/transferMoney/{ibanFrom}/{amount}/{ibanTo}")
    public void transferMoney(@PathVariable("ibanFrom") String accountWithdraw,
                                       @PathVariable("amount") double transferAmount,
                                       @PathVariable("ibanTo") String accountDeposit) {
        bankAccountService.transferMoney(accountWithdraw,transferAmount,accountDeposit);
        /*if (accountMap.get(accountWithdraw) == null && accountMap.get(accountWithdraw) == null) {
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
        */
    }

    @GetMapping("bankAccount/accountStatus/{iban}/{lock}")
    @CrossOrigin
    public boolean accountStatus(@PathVariable("iban") String iban, @PathVariable("lock") boolean lock) {
        return bankAccountService.accountStatus(iban,lock);
        //accountMap.get(iban).setAccountStatus(false);
    }

    @GetMapping("bankAccount/deleteAccount/{iban}")
    @CrossOrigin
    public void deleteAccount(@PathVariable("iban") String iban){
        bankAccountService.deleteAccount(iban);
    }

    @GetMapping("bankAccount/getAllAccounts")
    @CrossOrigin
    public List<AllAccounts> getAllAccounts(){
        return bankAccountService.getAllAccounts();
    }




}
