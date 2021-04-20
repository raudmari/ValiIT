package ee.bcs.valiit.service;

import ee.bcs.valiit.repository.BankAccountRepository;
import ee.bcs.valiit.tdoKlassid.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(BankAccount request) {
        bankAccountRepository.createAccount(request);
    }

    public String getBalance(String iban) {
        Boolean response = bankAccountRepository.accountStatus(iban);
        if (response == false) {
            return "Account locked! Turn to your account manager";
        } else {
            Double balance = bankAccountRepository.getBalance(iban);
            return "Account balance is € " + balance;
        }
    }

    public String depositMoney(String iban, double amount) {
        Boolean response = bankAccountRepository.accountStatus(iban);
        if (response == false) {
            return "Account locked! Turn to your account manager";
        } else if (amount < 1) {
            return "Nothing to deposit";
        } else {
            Double balance = bankAccountRepository.getBalance(iban);
            Double newBalance = balance + amount;
            bankAccountRepository.updateBalance(iban, newBalance);
            return "New balance is EUR " + newBalance;
        }
    }

    public String withdrawMoney(String iban, double amount) {
        Boolean response = bankAccountRepository.accountStatus(iban);
        Double balance = bankAccountRepository.getBalance(iban);
        if (response == false) {
            return "Account locked! Turn to your account manager";
        } else if (balance < amount) {
            return "Not enough funds";
        } else {
            Double newBalance = balance - amount;
            bankAccountRepository.updateBalance(iban, newBalance);
            return "New balance is " + (newBalance);
        }
    }

    public String transferMoney(String accountWithdraw, double transferAmount, String accountDeposit) {
        Boolean response1 = bankAccountRepository.accountStatus(accountWithdraw);
        Boolean response2 = bankAccountRepository.accountStatus(accountDeposit);
        Double balanceFrom = bankAccountRepository.getBalance(accountWithdraw);
        Double balanceTo = bankAccountRepository.getBalance(accountDeposit);
        if (response1 == false || response2 == false) {
            return "One of the accounts is locked. Transfer money not possible.";
        } else if (balanceFrom < transferAmount) {
            return "Not enough funds!";
        } else {
            Double newBalanceFrom = balanceFrom - transferAmount;
            bankAccountRepository.updateBalance(accountWithdraw, newBalanceFrom);
            Double newBalanceTo = balanceTo + transferAmount;
            bankAccountRepository.updateBalance(accountWithdraw, newBalanceTo);
            return "New balance after transfer for " + accountWithdraw + " is EUR " + newBalanceFrom + "\n" +
                    "New balance after transfer for " + accountDeposit + " is EUR " + newBalanceTo;
        }
    }

    public String accountStatus(String iban, boolean lock) {
        String accountStatus = "UPDATE bank_account SET account_status = :lock WHERE iban = :iban";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iban", iban);
        paramMap.put("lock", lock);
        jdbcTemplate.update(accountStatus, paramMap);
        return "Account status changed";
    }

}
