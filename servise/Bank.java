package servise;

import model.Account;

import java.util.HashMap;
import java.util.List;

public interface Bank {

    void createAccount();
    void dipositAmount();
    void WithdrawAmount();
    void transferFundInSameBank();

    void transferFundInDiffBank();

    void showLastTransactions();

    void checkAmount();
     HashMap<Integer, Account> getHashMap();

    void setHashMap(HashMap<Integer, Account> hashMap);

    HashMap<Integer, List<String>> getTrasaction();

    void setTrasaction(HashMap<Integer, List<String>> trasaction);



}
