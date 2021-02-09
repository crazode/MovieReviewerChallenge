package exceptions;

public class MovieAlreadyReviewedException extends Exception {
    public MovieAlreadyReviewedException(String message) {
        super(message);
    }
}
