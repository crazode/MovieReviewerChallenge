package exceptions;

public class MovieNotReleasedException extends Exception {
    public MovieNotReleasedException(String msg) {
        super(msg);
    }
}
