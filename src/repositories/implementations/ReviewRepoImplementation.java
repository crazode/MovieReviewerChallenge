package repositories.implementations;


import modals.Review;
import repositories.interfaces.ReviewRepo;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepoImplementation implements ReviewRepo {
    private final List<Review> reviews;
    public ReviewRepoImplementation(){
        this.reviews = new ArrayList<Review>();
    }

    public List<Review> getReviews() {
        return reviews;
    }


    @Override
    public Review addReview(String movieTitle, String userName, int rating, int wt){

        Review newReveiw = new Review(movieTitle, userName, rating, wt);
        reviews.add(newReveiw);
        return  newReveiw;
    }

    @Override
    public boolean movieAlreadyReviewedByUser(String movieTitle, String userName) {
        for (Review review : reviews) {
            if ((movieTitle.equals(review.getMovieTitle())) && (userName.equals(review.getUserName()))) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Review getReview( String userName, String movieTitle) {
        for (Review review : reviews) {
            if ((movieTitle.equals(review.getMovieTitle())) && (userName.equals(review.getUserName()))) {
                return review;
            }
        }
        return null;
    }
    @Override
    public double getAverageScoreOfMovie(String movieTitle) {
        double revCount = 0;
        double totalScore = 0;
        for (Review review : reviews) {
            if (review.getMovieTitle().equals(movieTitle)) {
                revCount++;
                totalScore += review.getRating() * review.getWt();
            }
        }
        if(revCount != 0){
            return (totalScore / revCount) ;
        }
        return 0;
    }


    @Override
    public double getAverageRatingForAllMovies(int year) {

        List<Review> reviewsForYear = reviewsForYear(year);
        double totalRating = 0.0D;
        int numberOfReviews = 0;

        for(Review review : reviewsForYear){
            totalRating+=(review.getRating()*review.getWt());
            numberOfReviews++;
        }
        return numberOfReviews>0 ? totalRating/numberOfReviews : 0.0D;

    }

    @Override
    public List<Review> reviewsForYear(int year) {
        List<Review> reviewsForYear = new ArrayList<>();
        for(Review review: reviews){
            if(review.getReviewYear() == year){
                reviewsForYear.add(review);
            }
        }
        return reviewsForYear;
    }
}
