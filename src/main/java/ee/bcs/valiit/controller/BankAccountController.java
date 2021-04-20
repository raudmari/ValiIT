package ee.bcs.valiit.controller;

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
    private NamedParameterJdbcTemplate jdbcTemplate;

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
    }*/

    private static Map<String, BankAccount> accountMap = new HashMap<>();

    // http://localhost:8080/bankAccount/createAccount
    @PostMapping("bankAccount/createAccount")
    public void createAccount(@RequestBody BankAccount request) {
        String sql = "INSERT INTO bank_account (iban, owner, balance, account_status) VALUES (:iban,:owner,:balance,:account_status)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("owner", request.getOwner());
        paramMap.put("iban", request.getIban());
        paramMap.put("balance", request.getBalance());
        paramMap.put("account_status", request.isAccountStatus());
        jdbcTemplate.update(sql, paramMap);
        // accountMap.put(request.getIban(), request);
    }


    // http://localhost:8080/bankAccount/getBalance
    @GetMapping("bankAccount/getBalance/{iban}")
    public String getBalance(@PathVariable("iban") String iban) {
     /*   if (accountMap.get(iban) == null) {
            String sql = "SELECT iban FROM bank_account WHERE iban = :iban";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("iban", iban);
            return "No account. Make new account.";
           } else if (accountMap.get(iban).isAccountStatus() == false) {
        return "Owner " + accountMap.get(iban).getOwner() + " account " + iban + " balance is EUR " + accountMap.get(iban).getBalance();
        }*/
        String accountStatus = "SELECT account_status FROM bank_account WHERE iban = :iban";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iban", iban);
        Boolean response = jdbcTemplate.queryForObject(accountStatus, paramMap, Boolean.class);
        if (response == false) {
            return "Account locked! Turn to your account manager";
        } else {
            String getBalance = "SELECT balance FROM bank_account WHERE iban = :iban";
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("iban", iban);
            Double balance = jdbcTemplate.queryForObject(getBalance, paramMap1, Double.class);
            return "Account balance is € " + balance;
        }
    }

    // http://localhost:8080/bankAccount/depositMoney/
    @GetMapping("bankAccount/depositMoney/{iban}/{amount}")
    public String depositMoney(@PathVariable("iban") String iban, @PathVariable("amount") double amount) {
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
        String accountStatus = "SELECT account_status FROM bank_account WHERE iban = :iban";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iban", iban);
        Boolean response = jdbcTemplate.queryForObject(accountStatus, paramMap, Boolean.class);
        if (response == false) {
            return "Account locked! Turn to your account manager";
        } else if (amount < 1) {
            return "Nothing to deposit";
        } else {
            String getBalance = "SELECT balance FROM bank_account WHERE iban = :iban";
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("iban", iban);
            Double oldBalance = jdbcTemplate.queryForObject(getBalance, paramMap1, Double.class);

            String depositAmount = "UPDATE bank_account SET balance = :amount WHERE iban = :iban";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("amount", oldBalance + amount);
            paramMap2.put("iban", iban);
            jdbcTemplate.update(depositAmount, paramMap2);
            return "New balance is EUR " + (oldBalance + amount);
        }
    }

    // http://localhost:8080/bankAccount/withdrawMoney/
    @GetMapping("bankAccount/withdrawMoney/{iban}/{amount}")
    public String withdrawMoney(@PathVariable("iban") String iban, @PathVariable("amount") double amount) {
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
        String accountStatus = "SELECT account_status FROM bank_account WHERE iban = :iban";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iban", iban);
        Boolean response = jdbcTemplate.queryForObject(accountStatus, paramMap, Boolean.class);

        String getBalance = "SELECT balance FROM bank_account WHERE iban = :iban";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("iban", iban);
        Double oldBalance = jdbcTemplate.queryForObject(getBalance, paramMap, Double.class);

        if (response == false) {
            return "Account locked! Turn to your account manager";
        } else if (oldBalance < amount) {
            return "Not enough funds";
        } else {
            String withdrawAmount = "UPDATE bank_account SET balance = :withdraw WHERE iban = :iban";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("withdraw", oldBalance - amount);
            paramMap2.put("iban", iban);
            jdbcTemplate.update(withdrawAmount, paramMap2);
            return "New balance is " + (oldBalance - amount);
        }
    }

    // http://localhost:8080/bankAccount/transferMoney/
    @GetMapping("bankAccount/transferMoney/{ibanFrom}/{amount}/{ibanTo}")
    public String transferMoney(@PathVariable("ibanFrom") String accountWithdraw,
                                       @PathVariable("amount") double transferAmount,
                                       @PathVariable("ibanTo") String accountDeposit) {
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
        String accountStatus1 = "SELECT account_status FROM bank_account WHERE iban = :ibanFrom";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ibanFrom", accountWithdraw);
        Boolean response1 = jdbcTemplate.queryForObject(accountStatus1, paramMap, Boolean.class);

        String accountStatus2 = "SELECT account_status FROM bank_account WHERE iban = :ibanTo";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("ibanTo", accountDeposit);
        Boolean response2 = jdbcTemplate.queryForObject(accountStatus2, paramMap1, Boolean.class);

        String getBalance = "SELECT balance FROM bank_account WHERE iban = :ibanFrom";
        Map<String,Object> paramMap2 = new HashMap<>();
        paramMap2.put("ibanFrom", accountWithdraw);
        Double withdrawBalance = jdbcTemplate.queryForObject(getBalance,paramMap2,Double.class);

        if(response1 == false || response2 == false){
            return "One of the accounts is locked. Transfer money not possible.";
        } else if(withdrawBalance < transferAmount){
            return "Not enough funds!";
        } else {
            String transferMoney = "UPDATE bank_account SET balance = :amount WHERE iban = :ibanFrom";
            Map<String,Object> paramMap3 = new HashMap<>();
            paramMap3.put("ibanFrom", accountWithdraw);
            paramMap3.put("amount", withdrawBalance - transferAmount);
            jdbcTemplate.update(transferMoney,paramMap3);

            String receiveMoney = "UPDATE bank_account SET balance = :amount WHERE iban = :ibanTo";
            Map<String ,Object> paramMap4 = new HashMap<>();
            paramMap4.put("ibanTo",accountDeposit);
            paramMap4.put("amount", accountDeposit + transferAmount);
            jdbcTemplate.update(receiveMoney,paramMap4);
            return "Account balance after transfer is EUR " + (accountDeposit + transferAmount);
        }
    }

    @GetMapping("bankAccount/accountStatus/{iban}/{lock}")
    public String accountStatus(@PathVariable("iban") String iban, @PathVariable("lock") boolean lock) {
        //accountMap.get(iban).setAccountStatus(false);
        String  accountStatus = "UPDATE bank_account SET account_status = :lock WHERE iban = :iban";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iban", iban);
        paramMap.put("lock", lock );
        jdbcTemplate.update(accountStatus, paramMap);
        return "Account status changed";
    }
}
