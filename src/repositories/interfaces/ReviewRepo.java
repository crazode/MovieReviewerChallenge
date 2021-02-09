package repositories.interfaces;

import modals.Review;

import java.util.List;

public interface ReviewRepo {
    Review addReview(String movieTitle, String userName, int rating, int wt);
    boolean movieAlreadyReviewedByUser(String movieTitle, String userName);
    Review getReview(String userName, String movieTitle);
    double getAverageScoreOfMovie(String movieTitle);
    double getAverageRatingForAllMovies(int year);
    List<Review> reviewsForYear(int year);
}
