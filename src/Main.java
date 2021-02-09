import exceptions.*;
import managers.MovieManager;
import managers.ReviewManager;
import managers.UserManager;
import modals.Genre;
import modals.Movie;
import repositories.implementations.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static ReviewRepoImplementation reviewRepo;
    private static UserReviewsCountRepoImpl userReviewsCountRepo ;
    private static CriticRepoImplementation criticRepo ;
    private static MovieRepoImplementation movieRepo;
    private static UserRepoImplementation userRepo;
    private static MovieManager movieController;
    private static ReviewManager reviewController;
    private static UserManager userController;
    private static void initialize() {

        reviewRepo = new ReviewRepoImplementation();
        userReviewsCountRepo = new UserReviewsCountRepoImpl();
        criticRepo = new CriticRepoImplementation(new HashSet<>());
        movieRepo = new MovieRepoImplementation(new HashSet<>());
        userRepo = new UserRepoImplementation();

        movieController = new MovieManager(movieRepo);
        reviewController = new ReviewManager(reviewRepo, userReviewsCountRepo, criticRepo, movieRepo, userRepo);
        userController = new UserManager(userRepo);
    }
    private static void checkInsertMovies() {
        Set<Genre> genreSet = new HashSet<>();
        genreSet.add(new Genre("Action"));
        genreSet.add(new Genre("Drama"));
        movieController.addMovie("Don", 2006,genreSet );

        genreSet = new HashSet<>();
        genreSet.add(new Genre("Drama"));
        movieController.addMovie("Tiger", 2008,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Comedy"));
        movieController.addMovie("Padmavat", 2006,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Drama"));
        movieController.addMovie("Lunchbox", 2021,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Romance"));
        movieController.addMovie("Metro", 2006,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Comedy"));
        genreSet.add(new Genre("Romance"));
        movieController.addMovie("Track", 2009,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Horror"));
        genreSet.add(new Genre("Thriller"));
        movieController.addMovie("Gone", 2009,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Horror"));
        genreSet.add(new Genre("Suspence"));
        genreSet.add(new Genre("Drama"));
        movieController.addMovie("Mad", 2008,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Comedy"));
        genreSet.add(new Genre("Slice of Life"));
        movieController.addMovie("School", 2006,genreSet );
        genreSet = new HashSet<>();
        genreSet.add(new Genre("Crime"));
        genreSet.add(new Genre("Thriller"));
        movieController.addMovie("Lost", 2022,genreSet );

    }

    private static void checkCreateUsers() {
        userController.addUser("SRK");
        userController.addUser("Salman");
        userController.addUser("Deepika");
    }

    private static void checkAddReviews() {
        try {
            reviewController.addReview("SRK", "Don", 2);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("SRK", "Mad", 4);
        } catch (MovieNotFoundException e) {
        e.printStackTrace();

    } catch (UserNotFoundException e) {
        e.printStackTrace();
    } catch (MovieNotReleasedException e) {
        e.printStackTrace();
    } catch (RatingNotInRangeException e) {
        e.printStackTrace();
    } catch (MovieAlreadyReviewedException e) {
        e.printStackTrace();

    }
        System.out.println();

        try {
            reviewController.addReview("Deepika", "Mad", 6);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();


        try {
            reviewController.addReview("SRK", "Padmavat", 8);
        }catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("Salman", "Don", 5);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("Deepika", "Don", 9);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("Deepika", "Guru", 6);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("SRK", "Don", 10);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("Deepika", "Lunchbox", 5);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("SRK", "Tiger", 5);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("SRK", "Metro", 7);
        }catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("Deepika", "Gone", 5);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("SRK", "Lost", 5);
        }catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("SRK", "School", 7);
        } catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();

        try {
            reviewController.addReview("SRK", "Gone", 7);
        }catch (MovieNotFoundException e) {
            e.printStackTrace();

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (MovieNotReleasedException e) {
            e.printStackTrace();
        } catch (RatingNotInRangeException e) {
            e.printStackTrace();
        } catch (MovieAlreadyReviewedException e) {
            e.printStackTrace();

        }
        System.out.println();
    }

    private static void checkAvreageMovieRating() {
        String movieTitle = "Don";
        System.out.println("Average rating for movie " + movieTitle + " : " + reviewController.getAverageRatingOfMovie(movieTitle));
        movieTitle = "Padmavat";
        System.out.println("Average rating for movie " + movieTitle + " : " + reviewController.getAverageRatingOfMovie(movieTitle));
        movieTitle = "Guru";
        System.out.println("Average rating for movie " + movieTitle + " : " + reviewController.getAverageRatingOfMovie(movieTitle));
        movieTitle = "Lunchbox";
        System.out.println("Average rating for movie " + movieTitle + " : " + reviewController.getAverageRatingOfMovie(movieTitle));
        movieTitle = "Tiger";
        System.out.println("Average rating for movie " + movieTitle + " : " + reviewController.getAverageRatingOfMovie(movieTitle));
    }
    private static void CheckAverageRatingOfYear() {
        int year = 2021;
        System.out.println("Average rating for the year "+ year + " :" + reviewController.getAverageRatingForAllMoviesIn(year));
        year = 2020;
        System.out.println("Average rating for the year "+ year + " :" + reviewController.getAverageRatingForAllMoviesIn(year));
    }

    public static void main(String[] arg){


        initialize();

        // added 10 movies
        checkInsertMovies();
        System.out.println();

        // Adding users to System
        checkCreateUsers();
        System.out.println();

        // Adding Reviews
        checkAddReviews();
        System.out.println();

        // average ratings of movies
        checkAvreageMovieRating();
        System.out.println();

        //average rating score of the year
        CheckAverageRatingOfYear();

        System.out.println();

        // top n movies of particular genre
        checkTopRatingMoviesReviewedByCritics();
        System.out.println("main successfully executed");




    }


    private static void checkTopRatingMoviesReviewedByCritics() {
        int n = 2;
        Genre genre = new Genre("Drama");
        System.out.println("Top " + n + " movies of genre " + genre.getGenreName() + " rated by critics are");
        List<Movie> topNMoviesRatedByCritics = reviewController.getTopNRatedMoviesByCriticsOfGenre(n, genre);
        showMovieList(topNMoviesRatedByCritics);
        genre = new Genre("Action");
        n = 5;
        System.out.println("Top " + n + " movies of genre " + genre.getGenreName() + " rated by critics are");
        topNMoviesRatedByCritics = reviewController.getTopNRatedMoviesByCriticsOfGenre(n, genre);
        showMovieList(topNMoviesRatedByCritics);
    }

    private static void showMovieList(List<Movie> topNMoviesRatedByCritics) {
        for(Movie movie : topNMoviesRatedByCritics){
            System.out.println(movie.getMovieTitle());
        }
    }


}
