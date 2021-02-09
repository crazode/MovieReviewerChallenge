package managers;

import exceptions.*;
import modals.*;
import repositories.implementations.*;

import java.util.*;

public class ReviewManager {
    private final ReviewRepoImplementation reviewRepo ;
    private final UserReviewsCountRepoImpl userReviewsCountRepo;
    private final CriticRepoImplementation criticRepo;
    private final MovieRepoImplementation movieRepo;
    private final UserRepoImplementation userRepo;
    private static final int YEAR_OF_RELEASE = 2000;
    private static final Set<Genre> SET_OF_GENRE = new HashSet<>();

    public ReviewManager(ReviewRepoImplementation reviewRepo, UserReviewsCountRepoImpl userReviewsCountRepo,
                         CriticRepoImplementation criticRepo, MovieRepoImplementation movieRepo,
                         UserRepoImplementation userRepo) {
        this.reviewRepo = reviewRepo;
        this.userReviewsCountRepo = userReviewsCountRepo;
        this.criticRepo = criticRepo;
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
    }




    public Review addReview(String userName, String movieTitle, int rating ) throws MovieNotFoundException,
            UserNotFoundException, MovieNotReleasedException, RatingNotInRangeException, MovieAlreadyReviewedException {
        if(rating > 10 || rating < 1){
            throw new RatingNotInRangeException("Rating " + rating + " not in range of 1 - 10.");
        }

       if(!movieRepo.movieExists(movieTitle)){
           throw new MovieNotFoundException("No movie with title "+ movieTitle +" present.");
       }
       if(!userRepo.userExists(userName)){
           throw new UserNotFoundException("No user with username "+ userName +" present.");

       }
       if(!movieRepo.isMovieReleased(movieTitle)){
           throw new MovieNotReleasedException("Movie " + movieTitle + " is not released yet");

       }
       if(reviewRepo.movieAlreadyReviewedByUser(movieTitle, userName)){
           throw new MovieAlreadyReviewedException(
                   "User " + userName + " has already reviewed movie " + movieTitle + ", can't review again !!");

       }

        Review review;
        if(criticRepo.isCritic(userName)){
            review = reviewRepo.addReview(movieTitle, userName, rating, 2);
       }else{
           review = reviewRepo.addReview(movieTitle, userName, rating, 1);
       }
       System.out.println("Review for movie " + movieTitle + " by user " + userName + " added successfully!! ");

       userReviewsCountRepo.updateRevCount(userName);
       checkAndMakeUserCritic(userName);

        return review;
    }

    private void checkAndMakeUserCritic(String userName) {
        if(userReviewsCountRepo.getRevCount(userName) == 3){
            criticRepo.addCritic(userName);
            System.out.println(userName + " has become a critic now");
        }
    }


    public double getAverageRatingForAllMoviesIn(int year){
        return reviewRepo.getAverageRatingForAllMovies(year);
    }


    public double getAverageRatingOfMovie(String movieTitle) {
        return reviewRepo.getAverageScoreOfMovie(movieTitle);
    }



    public List<Movie> getTopNRatedMoviesByCriticsOfGenre(int n, Genre genre) {
        List<Movie> topToLowRatedMoviesByCriticOfGenre = getMoviesByOrderedCriticRatingHighestToLowestBy(genre);
        return getFirstNEntriesFrom(n, topToLowRatedMoviesByCriticOfGenre);


    }

    private List<Movie> getMoviesByOrderedCriticRatingHighestToLowestBy(Genre genre) {
        Set<MovieCriticRating>movieCriticRatingSet = getMovieCriticRatings(genre);
        List<MovieCriticRating> movieCriticRatingFullList = new ArrayList<>(movieCriticRatingSet);
        sortMovieCriticRatings(movieCriticRatingFullList);
        List<Movie> topRatedMoviesByCriticOfGivenGenre = new ArrayList<>();
        for(MovieCriticRating movieCriticRating : movieCriticRatingFullList){
            String movieTitle = movieCriticRating.getMovieTitle();
            topRatedMoviesByCriticOfGivenGenre.add(movieRepo.getMovieByTitle(movieTitle));
        }
        return topRatedMoviesByCriticOfGivenGenre;
    }

    private void sortMovieCriticRatings(List<MovieCriticRating> movieCriticRatingFullList) {
        Collections.sort(movieCriticRatingFullList, new Comparator<MovieCriticRating>() {
            @Override
            public int compare(MovieCriticRating o1, MovieCriticRating o2) {
                double val = o1.getAverageRatingByCritics() - o2.getAverageRatingByCritics();
                if(val < 0){
                    return 1;
                }

                if(val > 0){
                    return -1;
                }
                return 0;
            }
        });
    }

    private List<Movie> getFirstNEntriesFrom(int n, List<Movie> topRatedMoviesByCriticOfGivenGenre) {
        if(n > topRatedMoviesByCriticOfGivenGenre.size()) {
            n = topRatedMoviesByCriticOfGivenGenre.size();
        }

        List<Movie> topNRatedMoviesByCriticOfGivenGenre = new ArrayList<>();
        for(int i = 0; i < n; i++){
            topNRatedMoviesByCriticOfGivenGenre.add(topRatedMoviesByCriticOfGivenGenre.get(i));
        }
        return  topNRatedMoviesByCriticOfGivenGenre;

    }

    private Set<MovieCriticRating> getMovieCriticRatings(Genre genre) {
        Map<String, Set<Review>> movieTitleToReviewsMap = getMovieTitleToReviewsMap(genre);

        Set<MovieCriticRating> movieCriticRatings = new HashSet<>();
        for(Map.Entry<String, Set<Review>> entry : movieTitleToReviewsMap.entrySet()){
            String movieTitle = entry.getKey();
            int n = movieTitleToReviewsMap.get(movieTitle).size();
            Set<Review> reviews = movieTitleToReviewsMap.get(movieTitle);
            double totalRating = getTotalRating(reviews);
            double averageRating = n > 0 ? totalRating / n : 0D;
            movieCriticRatings.add(new MovieCriticRating(movieTitle,averageRating));

        }
        return movieCriticRatings;
    }

    private double getTotalRating(Set<Review> reviews) {
        double totalRating = 0D;
        for(Review review : reviews){
            totalRating += review.getRating() * review.getWt();
        }
        return totalRating;
    }

    private Map<String, Set<Review>> getMovieTitleToReviewsMap(Genre genre) {
        Set<Review>criticReviewsForGenre = getCriticReviewsForGenre(genre);
        Map<String, Set<Review>> movieTitleToReviewMap = new HashMap<>();
        for(Review review : criticReviewsForGenre){
            Set<Review> reviewSet = new HashSet<>();
            if(!movieTitleToReviewMap.containsKey(review.getMovieTitle())){
                movieTitleToReviewMap.put(review.getMovieTitle(), new HashSet<>());

            }

            movieTitleToReviewMap.get(review.getMovieTitle()).add(review);

        }
        return  movieTitleToReviewMap;
    }

    private Set<Review> getCriticReviewsForGenre(Genre genre) {
        Set<Review> reviewsByCritic = getReviewsByCritics();
        Set<Movie> moviesOfGivenGenre = movieRepo.getMoviesOfGivenGenre(genre);
        Set<Review> reviewsForGenre = new HashSet<>();
        for(Review review : reviewsByCritic){
            if(moviesOfGivenGenre.contains(new Movie(review.getMovieTitle(), YEAR_OF_RELEASE, SET_OF_GENRE))){
                reviewsForGenre.add(review);
            }
        }
        return  reviewsForGenre;
    }


    private Set<Review> getReviewsByCritics() {
        Set<Review> criticReviews = new HashSet<>();
        for(Review review : reviewRepo.getReviews()){
            if(criticRepo.isCritic(review.getUserName())){
                criticReviews.add(review);
            }
        }
        return criticReviews;
    }
}
