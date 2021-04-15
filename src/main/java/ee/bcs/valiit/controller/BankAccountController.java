package ee.bcs.valiit.controller;

import ee.bcs.valiit.tdoKlassid.BankAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class BankAccountController {
    private static Map<String, BankAccount> accountMap = new HashMap<>();

    @PostMapping("bankAccount/createAccount")
    public void createAccount(@RequestBody BankAccount request) {
   //    accountMap.put(request.getIban(), request.getBalance(), request.getOwner(), request.isLocked());
    }

}
