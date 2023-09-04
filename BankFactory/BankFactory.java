package BankFactory;

import serviceImpl.HDFCBank;
import serviceImpl.ICICIBank;
import serviceImpl.SBIBank;
import servise.Bank;

public class BankFactory {

    public Bank getBank(Integer n) {

        if (n == 1) {
            return new HDFCBank();
        } else if (n == 2) {
            return new SBIBank();
        }
//        else if (n == 3) {
//            return new ICICIBank();
//        }
        else {
//            System.out.println("Please Enter Proper Number");
                return new ICICIBank();
        }
//            throw new Exception("Please Enter Proper Number");
        }
//    }


}
