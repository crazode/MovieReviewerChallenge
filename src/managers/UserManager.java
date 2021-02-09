package managers;

import modals.User;
import repositories.implementations.UserRepoImplementation;

public class UserManager {
    private final UserRepoImplementation userRepo;

    public UserManager(UserRepoImplementation userRepo){
        this.userRepo = userRepo;
    }

    public User addUser(String name){
      return userRepo.addUser(name);
    }
}
