package serviceImpl;

import BankException.AccountNotFoundException;
import BankException.InvalidAmountException;
import BankException.UnauthorizedActionException;
import BankUtil.BankUtil;
import model.Account;
import servise.Bank;

import java.time.LocalDateTime;
import java.util.*;

public class HDFCBank implements Bank {

    public static HashMap<Integer, Account> hashMap = new HashMap<>();

    public static HashMap<Integer, List<String>> trasaction = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    BankUtil bankUtil = new BankUtil();


    public HashMap<Integer, Account> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Integer, Account> hashMap) {
        HDFCBank.hashMap = hashMap;
    }

    public HashMap<Integer, List<String>> getTrasaction() {
        return trasaction;
    }

    public void setTrasaction(HashMap<Integer, List<String>> trasaction) {
        HDFCBank.trasaction = trasaction;
    }

    @Override
    public void createAccount() {

        Account account = bankUtil.createBank("HDFC");

        hashMap.put(account.getAccountNumber(),account);

        System.out.println(account);
        System.out.println(hashMap);
    }

    @Override
    public void dipositAmount() throws RuntimeException{


        System.out.println("Enter Account Number");
        int ac = sc.nextInt();
        System.out.println("Enter Amount");
        long amount = sc.nextLong();

        Account account = hashMap.get(ac);
        if (account==null){
            throw new AccountNotFoundException("Invalid Account Number Exception");
        }
        if (amount<1){
            throw new InvalidAmountException("Invalid Amount Exception");
        }
        account.setAmount(account.getAmount()+amount);
        System.out.println(amount+"rs Amount Added Successfully");

        List<String> list = trasaction.get(ac);
        if (list==null){
            List<String> list1 = new ArrayList<>();
            list1.add("dipositAmount: "+amount+ " on "+ LocalDateTime.now());
            trasaction.put(ac, list1);
        }
        else {
            list.add("dipositAmount: "+amount+ " on "+LocalDateTime.now());
            trasaction.put(ac, list);
        }


    }

    @Override
    public void WithdrawAmount() throws RuntimeException{

        System.out.println("Enter Account Number");
        int ac = sc.nextInt();
        System.out.println("Enter Password");
        int ps = sc.nextInt();
        System.out.println("Enter Amount");
        long amount = sc.nextLong();

        Account account = hashMap.get(ac);
        if (account==null){
            throw new AccountNotFoundException("Invalid Account Number Exception");
        }
        if (account.pin!=ps){
            throw new UnauthorizedActionException("Invalid athontication Exception");
        }
        if (account.getAmount()<amount){
            throw new InvalidAmountException("Invalid Amount Exception");
        }
        account.setAmount(account.getAmount()-amount);

        System.out.println(amount+"rs Debited Successfully");


        List<String> list = trasaction.get(ac);
        if (list==null){
            List<String> list1 = new ArrayList<>();
            list1.add("Withdraw Amount: "+amount+ " on "+LocalDateTime.now());
            trasaction.put(ac, list1);
        }
        else {
            list.add("Withdraw Amount: "+amount+ " on "+LocalDateTime.now());
            trasaction.put(ac, list);
        }
    }

    @Override
    public void transferFundInSameBank() throws RuntimeException{


        System.out.println("Enter Your Account Number");
        int ac1 = sc.nextInt();
        System.out.println("Enter Other Account Number");
        int ac2 = sc.nextInt();
        System.out.println("Enter Amount");
        long amount = sc.nextLong();

        Account account1 = hashMap.get(ac1);
        Account account2 = hashMap.get(ac2);

        if (account1==null){
            throw new AccountNotFoundException("Invalid Account Number 1 Exception");
        }
        if (account2==null){
            throw new AccountNotFoundException("Invalid Account Number 2 Exception");
        }
        if (amount>account1.getAmount()){
            throw new InvalidAmountException("Invalid Amount Exception");
        }
        account1.setAmount(account1.getAmount()-amount);
        account2.setAmount(account2.getAmount()+amount);

        System.out.println(amount+"rs Have Been Transfered Successfully");


        List<String> list = trasaction.get(ac1);
        if (list==null){
            List<String> list1 = new ArrayList<>();
            list1.add("Trasfer : "+amount+ " on "+LocalDateTime.now());
            trasaction.put(ac1, list1);
        }
        else {
            list.add("Transfer: "+amount+ " on "+LocalDateTime.now());
            trasaction.put(ac1, list);
        }

    }

    @Override
    public void transferFundInDiffBank() {


        System.out.println("Enter Your Account Number");
        int ac1 = sc.nextInt();

        Bank bank = bankUtil.selectBank();
        System.out.println("Enter Other Account Number");
        int ac2 = sc.nextInt();
        System.out.println("Enter Amount");
        long amount = sc.nextLong();

        Account account1 = hashMap.get(ac1);

        HashMap<Integer, Account> hashMap2 = bank.getHashMap();
        Account account2 = hashMap2.get(ac2);

        if (account1==null){
            throw new AccountNotFoundException("Invalid Account Number 1 Exception");
        }
        if (account2==null){
            throw new AccountNotFoundException("Invalid Account Number 2 Exception");
        }
        if (amount>account1.getAmount()){
            throw new InvalidAmountException("Invalid Amount Exception");
        }
        account1.setAmount(account1.getAmount()-amount);
        account2.setAmount(account2.getAmount()+amount);

        System.out.println(amount+"rs Have Been Transfered to other Account Successfully");


        List<String> list = trasaction.get(ac1);
        if (list==null){
            List<String> list1 = new ArrayList<>();
            list1.add("Trasfer : "+amount+ " on "+LocalDateTime.now());
            trasaction.put(ac1, list1);
        }
        else {
            list.add("Transfer: "+amount+ " on "+LocalDateTime.now());
            trasaction.put(ac1, list);
        }


//        second account
        HashMap<Integer, List<String>> trasaction2 = bank.getTrasaction();
        List<String> list2 = trasaction2.get(ac2);
        if (list2==null){
            List<String> list1 = new ArrayList<>();
            list1.add("Trasfer : "+amount+ " on "+LocalDateTime.now());
            trasaction2.put(ac2, list1);
        }
        else {
            list2.add("Transfer: "+amount+ " on "+LocalDateTime.now());
            trasaction2.put(ac2, list2);
        }




    }

    @Override
    public void showLastTransactions() throws RuntimeException{

        Account account = bankUtil.checkACandPW(hashMap);

        List<String> list = trasaction.get(account.getAccountNumber());

        for (String str:list){
            System.out.println(str);
        }


    }

    @Override
    public void checkAmount() throws RuntimeException{

        Account account = bankUtil.checkACandPW(hashMap);

        System.out.println("Total Amount : "+account.getAmount());

    }

}