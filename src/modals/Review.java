package modals;

import java.util.Calendar;
import java.util.Date;

public class Review {
    private String userName;
    private String movieTitle;
    private int rating;
    private int wt;
    private int reviewYear;


    public Review(String movieTitle,String userName, int rating, int wt) {
        this.userName = userName;
        this.movieTitle = movieTitle;
        this.rating = rating;
        this.wt = wt;
        this.reviewYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    public int getReviewYear() {
        return reviewYear;
    }

    public String getUserName() {
        return userName;
    }



    public String getMovieTitle() {
        return movieTitle;
    }



    public int getRating() {
        return rating;
    }



    public int getWt() {
        return wt;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Review review = (Review) o;
        return review.getMovieTitle().equals(movieTitle) && review.getUserName().equals(userName) && review.hashCode() == this.hashCode();

    }

    @Override
    public int hashCode() {
        return movieTitle.hashCode() + userName.hashCode();
    }
}
