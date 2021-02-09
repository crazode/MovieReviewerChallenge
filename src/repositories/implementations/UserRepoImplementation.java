package repositories.implementations;

import modals.User;
import repositories.interfaces.UserRepo;

import java.util.ArrayList;
import java.util.List;

public class UserRepoImplementation implements UserRepo {
    private final List<User> users;
    public UserRepoImplementation(){
        this.users = new ArrayList<>();
    }

    @Override
    public boolean userExists(String name){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserName() == name){
                return true;
            }
        }
        return false;
    }
    @Override
    public User addUser(String userName){
        if(users.contains(userName)){
            System.out.println("user " + userName + " already exists");
        }else{
            users.add(new User(userName));
            System.out.println("user " + userName + " added successfully");
        }
        return new User(userName);
    }
}
