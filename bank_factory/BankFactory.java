package bank_factory;

import service_impl.HDFCBank;
import service_impl.ICICIBank;
import service_impl.SBIBank;
import service.Bank;

public class BankFactory {

    public Bank getBank(Integer n) {

        if (n == 1) {
            return new HDFCBank();
        } else if (n == 2) {
            return new SBIBank();
        } else {
            return new ICICIBank();
        }
    }


}
