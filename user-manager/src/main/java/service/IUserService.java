package service;

import model.User;


import java.util.List;

public interface IUserService {
    void insertUser(User user);
//    List<User> selectAllUsers();

    boolean deleteUser(int id);

    boolean updateUser(User user);

    List<User> sortListUser();
    List<User> displayAllUsers();
}
