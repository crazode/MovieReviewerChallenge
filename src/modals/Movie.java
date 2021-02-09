package modals;

import java.util.Objects;
import java.util.Set;

public class Movie {
    private final String movieTitle;
    private final int yearOfRelease;
    private final Set<Genre> genreSet;

    public Movie(String movieTitle, int yearOfRelease, Set<Genre> genreSet) {
        this.movieTitle = movieTitle;
        this.yearOfRelease = yearOfRelease;
        this.genreSet = genreSet;
    }

    /**
     * if title same I am assuming the movie to be the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieTitle, movie.movieTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTitle);
    }

    public String getMovieTitle() {
        return movieTitle;
    }





    public int getYearOfRelease() {
        return yearOfRelease;
    }



    public Set<Genre> getGenreSet() {
        return this.genreSet;
    }


}
