package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4 {

    static Map<String, Double> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {


    }
    public static void crateAccount(String accountNr, double initialBalance) {
        accountBalanceMap.put(accountNr, initialBalance);
    }

    public static String getBalance(String accountNr) {
        if (accountBalanceMap.get(accountNr) == null) {
            return "No account available";
        } else {
            return "Your balance is " + accountBalanceMap.get(accountNr);
        }
    }

    public static String depositMoney(String accountNr, double deposit) {
        if (accountBalanceMap.get(accountNr) == null) {
            return "No account available";
        } else if (deposit < 1) {
            return "Nothing to deposit";
        } else {
            double balance = accountBalanceMap.get(accountNr) + deposit;
            accountBalanceMap.put(accountNr, balance);
            return "Your balance is " + balance;
        }
    }

    public static String withdrawMoney(String accountNr, double withdraw) {
        if (accountBalanceMap.get(accountNr) == null) {
            return "No account available";
        } else if (withdraw > accountBalanceMap.get(accountNr)) {
            return "Not enough funds";
        } else {
            double balance = accountBalanceMap.get(accountNr) - withdraw;
            accountBalanceMap.put(accountNr, balance);
            return "Your new balance is " + balance;
        }
    }

    public static String transferMoney(String accountWithdraw, String accountDeposit, double transferAmount) {
        if (accountBalanceMap.get(accountWithdraw) == null && accountBalanceMap.get(accountWithdraw) == null) {
            return "No account available";
        } else if (accountBalanceMap.get(accountWithdraw) < transferAmount) {
            return "Not enough funds";
        } else {
            double withdrawMoney = accountBalanceMap.get(accountWithdraw) - transferAmount;
            accountBalanceMap.put(accountWithdraw, withdrawMoney);
            double depositMoney = accountBalanceMap.get(accountDeposit) + transferAmount;
            accountBalanceMap.put(accountDeposit, depositMoney);
            return "Your new balance is " + depositMoney;
        }
    }

/*        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Create Account\n" +
                            "2. Get Account Balance\n" +
                            "3. Deposit Money\n" +
                            "4. Withdraw Money\n" +
                            "5. Transfer Money\n" +
                            "6. Exit\n");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Crate new account. Insert new account number.");
                String accountNr = scanner.nextLine();
                System.out.println("New account Nr: " + accountNr + ". Current account balance is EUR " + accountBalanceMap.put(accountNr, 0.0));

            } else if (choice == 2) {
                System.out.println("Insert account number:");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                if (accountBalanceMap.get(accountNr) == null) {
                    System.out.println("No account available. Create new account!");
                } else {
                    System.out.println("Your account balance is EUR: " + balance);
                }


            } else if (choice == 3) {
                System.out.println("Insert account number:");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                System.out.println("Account Nr: " + accountNr + " balance is EUR " + balance);
                System.out.println("Insert deposit amount:");
                Double deposit = scanner.nextDouble();
                scanner.nextLine();
                if (accountBalanceMap.get(accountNr) == null) {
                    System.out.println("No account available. Create new account!");
                } else if (deposit > 0) {
                    balance = balance + deposit;
                    System.out.println("Account Nr: " + accountNr + " new balance after deposit is EUR " + balance);
                    accountBalanceMap.put(accountNr, balance);
                } else {
                    System.out.println("No amount to deposit");
                }

            } else if (choice == 4) {
                System.out.println("Insert account number:");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                System.out.println("Account Nr: " + accountNr + " balance is EUR " + balance);
                System.out.println("Insert withdraw amount:");
                Double withdraw = scanner.nextDouble();
                scanner.nextLine();
                if (accountBalanceMap.get(accountNr) == null) {
                    System.out.println("No account available. Create new account!");
                } else if (withdraw < 1) {
                    System.out.println("Nothing to withdraw");
                } else if (balance >= withdraw) {
                    balance = balance - withdraw;
                    System.out.println("Account Nr: " + accountNr + " new balance after withdraw is EUR " + balance);
                    accountBalanceMap.put(accountNr, balance);
                } else {
                    System.out.println("Not enough funds on the account.");
                }

            } else if (choice == 5) {
                System.out.println("Insert Withdraw Account number:");
                String withdrawAccount = scanner.nextLine();
                Double withdrawAccountBalance = accountBalanceMap.get(withdrawAccount);
                System.out.println("Account Nr: " + withdrawAccount + " balance is EUR " + withdrawAccountBalance);
                System.out.println("Insert transfer amount");
                Double transferAmount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Insert Deposit Account number:");
                String depositAccount = scanner.nextLine();
                Double depositAccountBalance = accountBalanceMap.get(depositAccount);
                if (accountBalanceMap.get(withdrawAccount) == null || accountBalanceMap.get(depositAccount) == null) {
                    System.out.println("No account. Create new account!");
                } else if (withdrawAccountBalance >= transferAmount) {
                    withdrawAccountBalance = withdrawAccountBalance - transferAmount;
                    depositAccountBalance = depositAccountBalance + transferAmount;
                    accountBalanceMap.put(withdrawAccount, withdrawAccountBalance);
                    accountBalanceMap.put(depositAccount, depositAccountBalance);
                    System.out.println("After transaction:");
                    System.out.println("Account Nr: " + withdrawAccount + " new balance is EUR " + withdrawAccountBalance);
                    System.out.println("Account Nr: " + depositAccount + " new balance is EUR " + depositAccountBalance);

                } else if (transferAmount < 1) {
                    System.out.println("No amount to transfer");

                } else {
                    System.out.println("Not enough funds to transfer!");
                }
            } else if (choice == 6) {
                System.out.println("Exit program");
                break;

            } else {
                System.out.println("Unknown command");
            }
        }*/

}














