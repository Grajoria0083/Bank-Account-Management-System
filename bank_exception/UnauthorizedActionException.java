package bank_exception;

public class UnauthorizedActionException extends RuntimeException{

    public UnauthorizedActionException() {
    }

    public UnauthorizedActionException(String message) {
        super(message);
    }
}
