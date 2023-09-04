package BankException;

public class ExternalBankTransferException extends RuntimeException{

    public ExternalBankTransferException() {

    }

    public ExternalBankTransferException(String message) {
        super(message);
    }
}
