package managers;

import modals.Genre;
import modals.Movie;
import repositories.implementations.MovieRepoImplementation;

import java.util.Set;

public class MovieManager {
    private final MovieRepoImplementation movieRepo;

    public MovieManager(MovieRepoImplementation movieRepo){
        this.movieRepo = movieRepo;
    }

    public Movie addMovie(String title, int yearOfRelease, Set<Genre> genreSet){
        return movieRepo.addMovie(title, yearOfRelease, genreSet);
    }
}
