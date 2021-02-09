package repositories.implementations;

import modals.Genre;
import modals.Movie;
import repositories.interfaces.MovieRepo;

import java.util.*;

public class MovieRepoImplementation implements MovieRepo {
    private static final int DUMMY_YEAR_OF_RELEASE = 2000;
    private static final Set<Genre> EMPTY_GENRE_SET = new HashSet<>();
    private final Set<Movie> movies;

    public Set<Movie> getMovies() {
        return movies;
    }

    public MovieRepoImplementation(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean movieExists(String movieTitle){
        return movies.contains(new Movie(movieTitle, DUMMY_YEAR_OF_RELEASE, EMPTY_GENRE_SET));
    }

    @Override
    public Movie addMovie(String movieTitle, int yearOfRelease, Set<Genre> genreSet){
        Movie newMovie = new Movie(movieTitle, yearOfRelease, genreSet);

        if(!movies.contains(newMovie)){
            movies.add(newMovie);
            System.out.println("Movie " + movieTitle + " year of release " + yearOfRelease + " is added successfully");

        }else{
            System.out.println("Movie " + movieTitle + " is already added");

        }
        return newMovie;

    }

    @Override
    public boolean isMovieReleased(String movieTitle){
        Movie movieByTitle = getMovieByTitle(movieTitle);
        if (null != movieByTitle && movieByTitle.getYearOfRelease() <= Calendar.getInstance().get(Calendar.YEAR)) {
                return true;
            }

        return false;
    }

    @Override
    public Movie getMovieByTitle(String movieTitle) {
        for (Movie movie : movies) {
            if (movie.getMovieTitle().equals(movieTitle)) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public Set<Movie> getMoviesOfGivenGenre(Genre genre) {
        Set<Movie> moviesOfGivenGenre = new HashSet<>();
        for(Movie movie : movies){
            if(movie.getGenreSet().contains(genre)){
                moviesOfGivenGenre.add(movie);
            }
        }
        return moviesOfGivenGenre;
    }
}
