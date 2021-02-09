package repositories.interfaces;

import modals.Genre;
import modals.Movie;

import java.util.Set;

public interface MovieRepo {
    boolean movieExists(String movieTitle);
    Movie addMovie(String movieTitle, int yearOfRelease, Set<Genre> genreSet);
    boolean isMovieReleased(String movieTitle);
    Movie getMovieByTitle(String movieTitle);
    Set<Movie> getMoviesOfGivenGenre(Genre genre);
}
