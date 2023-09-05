package servise;

import model.Account;

import java.util.HashMap;
import java.util.List;

public interface Bank {

    void joint();

    void createAccount();
    void dipositAmount();
    void WithdrawAmount();
    void transferFundInSameBank();

    void transferFundInDiffBank();

    void showLastTransactions();

    void checkAmount();

    default void BankLunchTiming(){
        System.out.println("Bank Lunch Time is 1pm to 2pm");
    }

    static void requirement(){
        System.out.println("Aadhaar Cart is mendetory");
    }



     HashMap<Integer, Account> getHashMap();

    void setHashMap(HashMap<Integer, Account> hashMap);

    HashMap<Integer, List<String>> getTrasaction();

    void setTrasaction(HashMap<Integer, List<String>> trasaction);



}
