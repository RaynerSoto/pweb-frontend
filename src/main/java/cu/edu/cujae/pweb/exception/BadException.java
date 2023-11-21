package cu.edu.cujae.pweb.exception;

public class BadException extends Exception{
    public BadException() {
    }

    public BadException(String message) {
        super(message);
    }

    public BadException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadException(Throwable cause) {
        super(cause);
    }

    public BadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
