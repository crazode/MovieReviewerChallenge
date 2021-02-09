package repositories.implementations;

import repositories.interfaces.UserReviewsCountRepo;

import java.util.HashMap;
import java.util.Map;

public class UserReviewsCountRepoImpl implements UserReviewsCountRepo {
    private final Map<String, Integer> reviewsCount;
    public UserReviewsCountRepoImpl(){
        reviewsCount = new HashMap<String, Integer>();
    }
    @Override
    public synchronized void updateRevCount(String userName){
        if(!reviewsCount.containsKey(userName)){
            reviewsCount.put(userName, 1);
        }else{
            reviewsCount.put(userName, reviewsCount.get(userName) + 1);
        }
    }
    @Override
    public int getRevCount(String name){
        return reviewsCount.get(name);
    }

}
