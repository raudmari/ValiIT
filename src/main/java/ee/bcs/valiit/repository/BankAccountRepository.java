package ee.bcs.valiit.repository;

import ee.bcs.valiit.tdoKlassid.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(BankAccount request) {
        String sql = "INSERT INTO bank_account (iban, owner, balance, account_status) VALUES (:iban,:owner,:balance,:account_status)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("owner", request.getOwner());
        paramMap.put("iban", request.getIban());
        paramMap.put("balance", request.getBalance());
        paramMap.put("account_status", request.isAccountStatus());
        jdbcTemplate.update(sql, paramMap);
    }

    public double getBalance(String iban) {
        String getBalance = "SELECT balance FROM bank_account WHERE iban = :iban";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("iban", iban);
        return jdbcTemplate.queryForObject(getBalance, paramMap1, Double.class);
    }

    public void updateBalance(String iban, double amount) {
        String depositAmount = "UPDATE bank_account SET balance = :amount WHERE iban = :iban";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("amount", amount);
        paramMap2.put("iban", iban);
        jdbcTemplate.update(depositAmount, paramMap2);
    }

    public boolean accountStatus(String iban) {
        String accountStatus = "SELECT account_status FROM bank_account WHERE iban = :iban";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("iban", iban);
        return jdbcTemplate.queryForObject(accountStatus, paramMap, Boolean.class);
    }
}


