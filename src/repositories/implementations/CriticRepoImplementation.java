package repositories.implementations;

import modals.User;
import repositories.interfaces.CriticRepo;

import java.util.Set;

public class CriticRepoImplementation implements CriticRepo {
    private final Set<User> critics;

    public Set<User> getCritics() {
        return critics;
    }



    public CriticRepoImplementation(final Set<User> critics){
        this.critics = critics;
    }

    @Override
    public boolean isCritic(String userName){
        return critics.contains(new User(userName));

    }
    @Override
    public void addCritic(String userName){
        critics.add(new User(userName));
    }
}
