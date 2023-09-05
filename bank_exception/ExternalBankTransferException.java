package bank_exception;

public class ExternalBankTransferException extends RuntimeException{

    public ExternalBankTransferException() {

    }

    public ExternalBankTransferException(String message) {
        super(message);
    }
}
