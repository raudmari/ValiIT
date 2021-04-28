package ee.bcs.valiit.service;

import ee.bcs.valiit.exception.ApplicationException;
import ee.bcs.valiit.hibernate.BankAccountHibernate;
import ee.bcs.valiit.hibernate.HibernateBankAccountRepository;
import ee.bcs.valiit.repository.BankAccountRepository;
import ee.bcs.valiit.tdoKlassid.AllAccounts;
import ee.bcs.valiit.tdoKlassid.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private HibernateBankAccountRepository hibernateBankAccountRepository;

    public void createAccount(BankAccount request) {
        bankAccountRepository.createAccount(request);
    }

    public Double getBalance(String iban) {
        BankAccountHibernate bankAccount = hibernateBankAccountRepository.getOne(iban);
       // Boolean response = bankAccountRepository.accountStatus(iban);
        if (bankAccount.getAccountStatus() == false) {
            throw new ApplicationException("Account is locked");
        } else {
             return bankAccount.getBalance();
            //Double balance = bankAccountRepository.getBalance(iban);
            // return "Account balance is € " + balance;
        }
    }

    public Double depositMoney(String iban, double amount) {
        BankAccountHibernate bankAccount = hibernateBankAccountRepository.getOne(iban);
        //Boolean response = bankAccountRepository.accountStatus(iban);
        if (bankAccount.getAccountStatus() == false) {
            throw new ApplicationException("Account is locked");
        } else if (amount < 1) {
            throw new ApplicationException("Nothing to deposit");
        } else {
            Double balance = bankAccount.getBalance();
            //Double balance = bankAccountRepository.getBalance(iban);
            Double newBalance = balance + amount;
            bankAccount.setBalance(newBalance);
            hibernateBankAccountRepository.save(bankAccount);
            //bankAccountRepository.updateBalance(iban, newBalance);

            return newBalance;
        }
    }

    public Double withdrawMoney(String iban, double amount) {
        BankAccountHibernate bankAccount = hibernateBankAccountRepository.getOne(iban);
        //Boolean response = bankAccountRepository.accountStatus(iban);
        Double balance = bankAccount.getBalance();
        //Double balance = bankAccountRepository.getBalance(iban);
        if (bankAccount.getAccountStatus() == false) {
            throw new ApplicationException("Account is locked");
        } else if (balance < amount) {
            throw new ApplicationException("Not enough funds on account");
        } else {
            Double newBalance = balance - amount;
            bankAccount.setBalance(newBalance);
            hibernateBankAccountRepository.save(bankAccount);
            //bankAccountRepository.updateBalance(iban, newBalance);
            return newBalance;
        }
    }

    public void transferMoney(String accountWithdraw, double transferAmount, String accountDeposit) {
        BankAccountHibernate accountFrom = hibernateBankAccountRepository.getOne(accountWithdraw);
        BankAccountHibernate accountTo = hibernateBankAccountRepository.getOne(accountDeposit);
        //Boolean response1 = bankAccountRepository.accountStatus(accountWithdraw);
        //Boolean response2 = bankAccountRepository.accountStatus(accountDeposit);
        Double balanceFrom = accountFrom.getBalance();
        Double balanceTo = accountTo.getBalance();
        //Double balanceFrom = bankAccountRepository.getBalance(accountWithdraw);
        //Double balanceTo = bankAccountRepository.getBalance(accountDeposit);
        if (accountFrom.getAccountStatus() == false || accountTo.getAccountStatus() == false) {
            throw new ApplicationException("One of the accounts is locked. Transfer money not possible.");
        } else if (balanceFrom < transferAmount) {
            throw new ApplicationException ("Not enough funds on account");
        } else {
            Double newBalanceFrom = balanceFrom - transferAmount;
            accountFrom.setBalance(newBalanceFrom);
            hibernateBankAccountRepository.save(accountFrom);
            //bankAccountRepository.updateBalance(accountWithdraw, newBalanceFrom);
            Double newBalanceTo = balanceTo + transferAmount;
            accountTo.setBalance(newBalanceTo);
            hibernateBankAccountRepository.save(accountTo);
            //bankAccountRepository.updateBalance(accountWithdraw, newBalanceTo);
        }
    }

    public boolean accountStatus(String iban, boolean lock) {
        BankAccountHibernate bankAccount = hibernateBankAccountRepository.getOne(iban);
        //bankAccountRepository.accountStatus(iban, lock);
        bankAccount.setAccountStatus(lock);
        hibernateBankAccountRepository.save(bankAccount);
        return bankAccount.getAccountStatus();
    }

    public void deleteAccount(String iban) {
        BankAccountHibernate bankAccount = hibernateBankAccountRepository.getOne(iban);
        if (bankAccount.getAccountStatus() == false) {
            throw new ApplicationException("Account is locked");
        } else {
            hibernateBankAccountRepository.delete(bankAccount);
        }
    }

    public List<AllAccounts> getAllAccounts() {
        List<BankAccountHibernate> info = hibernateBankAccountRepository.findAll();
        List<AllAccounts> allAccounts = new ArrayList<>();
        for (BankAccountHibernate hibernate : info) {
            allAccounts.add(new AllAccounts(hibernate));
        }
        return allAccounts;
    }
}
