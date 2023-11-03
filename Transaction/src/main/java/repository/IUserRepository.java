package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getUser();
    void editUser(int userId, String name, int age, String nation);
    void deleteUser(int userId);
    User getUserById(int userId);
    void addUser(String name, int age, String nation);
}
