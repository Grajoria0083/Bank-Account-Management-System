import BankFactory.BankFactory;
import BankUtil.BankUtil;
import serviceImpl.HDFCBank;
import serviceImpl.ICICIBank;
import serviceImpl.SBIBank;
import servise.Bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankUtil bankUtil = new BankUtil();
        Bank bank;
        Scanner sc = new Scanner(System.in);
        int n = 0;


        while (true) {

            System.out.println("Please Select Bank");

            bank = bankUtil.selectBank();

            System.out.println("Enter number as per Service");

            System.out.println("1 Creating Account");
            System.out.println("2 Withdraw Amount");
            System.out.println("3 Diposite Amount");
            System.out.println("4 Transfer Fund in Same Bank");
            System.out.println("5 Transfer Fund in Different Bank");
            System.out.println("6 Show Last Transactions");
            System.out.println("7 Check Amount");

            n = sc.nextInt();


            switch (n) {
                case 1:
                    try {
                        bank.createAccount();
                    }catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 2:
                    try {
                        bank.WithdrawAmount();
                    }catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 3:
                    try {
                        bank.dipositAmount();
                    }catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 4:
                    try {
                        bank.transferFundInSameBank();
                    }catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 5:
                    try {
                        bank.transferFundInDiffBank();
                    }catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 6:
                    try {
                        bank.showLastTransactions();
                    }catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                case 7:
                    try {
                        bank.checkAmount();
                    }catch (RuntimeException re) {
                        System.out.println(re.getMessage());
                    }
                    break;
                default:
                    System.out.println("Please enter a valid number");
            }
        }

    }
}
