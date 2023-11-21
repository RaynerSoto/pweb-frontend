package cu.edu.cujae.pweb.exception;

public class GoodException extends Exception{
    public GoodException() {
    }

    public GoodException(String message) {
        super(message);
    }

    public GoodException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodException(Throwable cause) {
        super(cause);
    }

    public GoodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
