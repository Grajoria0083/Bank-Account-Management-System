package BankUtil;

import BankException.AccountNotFoundException;
import BankException.InvalidAmountException;
import BankException.UnauthorizedActionException;
import BankFactory.BankFactory;
import model.Account;
import servise.Bank;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class BankUtil {


    public Account createBank(String bankName){

        Account account = new Account();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name");
        String name = sc.next();

        System.out.println("Enter email");
        String email = sc.next();

        System.out.println("Enter phone number");
        String pn = sc.next();

        System.out.println("Enter Address");
        String address = sc.next();

        System.out.println("create password");
        int pw = sc.nextInt();

        System.out.println("Select Branch");
        System.out.println("0 Noida");
        System.out.println("1 Delhi");
        System.out.println("3 Gurgaon");
        int n = sc.nextInt();

        if (n == 1) {
            account.setBranch("Noida");
            account.setIfscCode(bankName.toUpperCase()+4342);
        } else if (n == 2) {
            account.setBranch("Delhi");
            account.setIfscCode(bankName.toUpperCase()+4341);
        }
        else {
            account.setBranch("Gurgaon");
            account.setIfscCode(bankName.toUpperCase()+4345);
        }

        Random rand = new Random();
        int ac = rand.nextInt(1000000)+9999999;

        account.setAccountNumber(ac);
        account.setName(name);
        account.setPhoneNumber(pn);
        account.setAddress(address);
        account.setPin(pw);
        account.setBankName(bankName);
        account.setAmount(0);

        return account;
    }




    public Account checkACandPW(HashMap<Integer, Account> hashMap){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Number");
        int ac = sc.nextInt();
        System.out.println("Enter Password");
        int ps = sc.nextInt();

        Account account = hashMap.get(ac);
        if (account==null){
            throw new AccountNotFoundException("Invalid Account Number Exception");
        }
        if (account.pin!=ps){
            throw new UnauthorizedActionException("Invalid athontication Exception");
        }
        return account;
    }



    public Account checkACandAmount(HashMap<Integer, Account>  hashMap){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Number");
        int ac = sc.nextInt();
        System.out.println("Enter Amount");
        long amount = sc.nextLong();

        Account account = (Account) hashMap.get(ac);
        if (account==null){
            throw new AccountNotFoundException("Invalid Account Number Exception");
        }
        if (amount<1){
            throw new InvalidAmountException("Invalid Amount Exception");
        }
        return account;
    }

    public void checkACandAmountandPW(HashMap<Integer, Account>  hashMap){

        Scanner sc  =new Scanner(System.in);

        System.out.println("Enter Account Number");
        int ac = sc.nextInt();
        System.out.println("Enter Password");
        int ps = sc.nextInt();
        System.out.println("Enter Amount");
        long amount = sc.nextLong();

        Account account = (Account) hashMap.get(ac);
        if (account==null){
            throw new AccountNotFoundException("Invalid Account Number Exception");
        }
        if (account.pin!=ps){
            throw new UnauthorizedActionException("Invalid athontication Exception");
        }
        if (account.getAmount()<amount) {
            throw new InvalidAmountException("Invalid Amount Exception");

        }
    }





    public void checkAC1andAC2andAmount(HashMap<Integer, Account>  hashMap){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Account Number");
        int ac1 = sc.nextInt();
        System.out.println("Enter Other Account Number");
        int ac2 = sc.nextInt();
        System.out.println("Enter Amount");
        long amount = sc.nextLong();

        Account account1 = (Account) hashMap.get(ac1);
        Account account2 = (Account) hashMap.get(ac2);

        if (account1==null){
            throw new AccountNotFoundException("Invalid Account Number 1 Exception");
        }
        if (account2==null){
            throw new AccountNotFoundException("Invalid Account Number 2 Exception");
        }
        if (amount>account1.getAmount()){
            throw new InvalidAmountException("Invalid Amount Exception");
        }
        return;
    }



    public Bank selectBank(){

        Scanner sc = new Scanner(System.in);

        System.out.println("1 HDFC Bank");
        System.out.println("2 SBI Bank");
        System.out.println("3 ICICI Bank");

        int n = sc.nextInt();
        BankFactory bf = new BankFactory();
        return bf.getBank(n);
    }


}
