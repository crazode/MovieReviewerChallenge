package modals;

import java.util.Objects;

public class MovieCriticRating {
    private final String movieTitle;
    private final double averageRatingByCritics;

    public MovieCriticRating(String movieTitle, double averageRatingByCritics) {
        this.movieTitle = movieTitle;
        this.averageRatingByCritics = averageRatingByCritics;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
    public double getAverageRatingByCritics() {
        return this.averageRatingByCritics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCriticRating movieCriticRating = (MovieCriticRating) o;
        return Objects.equals(this.movieTitle, movieCriticRating.movieTitle) && this.averageRatingByCritics == movieCriticRating.averageRatingByCritics;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieTitle) + Objects.hash(averageRatingByCritics);
    }


}
