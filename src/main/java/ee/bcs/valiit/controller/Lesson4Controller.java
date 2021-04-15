package ee.bcs.valiit.controller;

import ee.bcs.valiit.tasks.Lesson4;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson4Controller {

    // http://localhost:8080/createAccount/EE123/0.00
    @GetMapping("createAccount/{accountNr}/{initialBalance}")
    public void createAccount(@PathVariable("accountNr") String accountNr, @PathVariable("initialBalance") double initialBalance){

    }

    // http://localhost:8080/getBalance/EE123
    @GetMapping("getBalance/{accountNr}")
    public String getBalance(@PathVariable("accountNr") String accountNr){
        return Lesson4.getBalance(accountNr);
    }

    // http://localhost:8080/depositMoney/EE123
    @GetMapping("depositMoney/{accountNr}/{deposit}")
    public String depositMoney(@PathVariable("accountNr") String accountNr,@PathVariable("deposit") double deposit){
        return Lesson4.depositMoney(accountNr,deposit);
    }

    // http://localhost:8080/withdrawMoney/EE123
    @GetMapping("withdrawMoney/{accountNr}/{withdraw}")
    public String withdrawMoney(@PathVariable("accountNr") String accountNr,@PathVariable("withdraw") double withdraw){
        return Lesson4.withdrawMoney(accountNr,withdraw);
    }

    // http://localhost:8080/transferMoney/EE123/EE098/2000
    @GetMapping("transferMoney/{fromAccount}/{toAccount}/{amount}")
    public String transferMoney(@PathVariable("fromAccount") String fromAccount,@PathVariable("toAccount") String toAccount,@PathVariable("amount") double amount){
        return Lesson4.transferMoney(fromAccount,toAccount,amount);
    }







}
