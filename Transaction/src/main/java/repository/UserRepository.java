package repository;

import model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    private static final String DISPLAY = "call display_user();";
    private static final String EDIT = "call edit_user(?, ?, ?, ?);";
    private static final String DELETE = "call delete_user(?);";
    private static final String GET_USER_BY_ID = "call get_user(?)";
    private static final String ADD_USER = "insert into `users`(`user_name`, `age`,`nation`) value (?,?,?);";
    @Override
    public List<User> getUser(){
        Connection connection = BaseRepository.getConnection();
        List<User> list = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall(DISPLAY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int userId = Integer.parseInt(resultSet.getString(1));
                String userName = resultSet.getString(2);
                int userAge = Integer.parseInt(resultSet.getString(3));
                String userNation = resultSet.getString(4);
                list.add(new User(userId, userName, userAge, userNation));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void editUser(int userId, String name, int age, String nation){
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement statement = connection.prepareCall(EDIT);
            statement.setInt(1, userId);
            statement.setString(2, name);
            statement.setInt(3, age);
            statement.setString(4, nation);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int userId) {
        Connection connection = BaseRepository.getConnection();
        try {
            CallableStatement statement = connection.prepareCall(DELETE);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(int userId) {
        Connection connection = BaseRepository.getConnection();
        List<User> list = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall(GET_USER_BY_ID);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString(1));
                String userName = resultSet.getString(2);
                int userAge = Integer.parseInt(resultSet.getString(3));
                String userNation = resultSet.getString(4);
                list.add(new User(id, userName, userAge, userNation));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list.get(0);
    }

    @Override
    public void addUser(String name, int age, String nation) {
        Connection connection = BaseRepository.getConnection();

        try {
            connection.setAutoCommit(false);
            CallableStatement statement = connection.prepareCall(ADD_USER);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, nation);
            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
