package repositories.interfaces;

public interface UserReviewsCountRepo {
    void updateRevCount(String userName);
    int getRevCount(String name);
}
