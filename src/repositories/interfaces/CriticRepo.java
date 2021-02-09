package repositories.interfaces;

public interface CriticRepo {
    boolean isCritic(String userName);
    void addCritic(String userName);
}
