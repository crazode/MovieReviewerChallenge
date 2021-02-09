package exceptions;

public class RatingNotInRangeException extends Exception {
    public RatingNotInRangeException(String msg) {
        super(msg);
    }
}
