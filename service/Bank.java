package service;

import model.Account;

import java.util.HashMap;
import java.util.List;

public interface Bank {

    void joint();

    void createAccount();
    void dipositAmount();
    void withdrawAmount();
    void transferFundInSameBank();

    void transferFundInDiffBank();

    void showLastTransactions();

    void checkAmount();

    default void bankLunchTiming(){
        System.out.println("Bank Lunch Time is 1pm to 2pm");
    }

    static void requirement(){
        System.out.println("Aadhaar Card is mandatory");
    }



     HashMap<Integer, Account> getHashMap();

    void setHashMap(HashMap<Integer, Account> hashMap);

    HashMap<Integer, List<String>> getTransaction();

    void setTransaction(HashMap<Integer, List<String>> transaction);



}
