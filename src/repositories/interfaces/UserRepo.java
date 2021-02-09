package repositories.interfaces;

import modals.User;

public interface UserRepo {
    boolean userExists(String name);
    User addUser(String name);
}
