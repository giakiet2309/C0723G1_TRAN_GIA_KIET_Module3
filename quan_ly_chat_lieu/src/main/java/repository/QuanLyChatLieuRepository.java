package repository;

import model.QuanLyChatLieu;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyChatLieuRepository implements IQuanLyChatLieuRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/quan_ly_ban_hang";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "insert into chat_lieu (id,ma_chat_lieu,ten,mo_ta) values (?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "select * from chat_lieu where ma_chat_lieu=? ";

    private static final String SEARCH_USERS_SQL = "select ten from chat_lieu where ten != 'not found';";

    private static final String DISPLAY_ALL_USERS = "call display_all()";

    private static final String UPDATE_USERS = "call update_all(?,?,?,?)";

    private static final String SELECT_ID_BY_CODE = "select id from chat_lieu where ma_chat_lieu =  ?;";

    private static final String SEARCH_SIZE_BY_NAME = " select ma_chat_lieu,ten,mo_ta from chat_lieu where 1 = 1 and  ten != 'not found'";

    private static final String DELETE_BY_ID = "update chat_lieu set ten = 'not found', mo_ta = 'not found' where id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(QuanLyChatLieu quanLyChatLieu) {
        System.out.println(INSERT_USERS_SQL);
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, quanLyChatLieu.getId());
            preparedStatement.setString(2, quanLyChatLieu.getNameId());
            preparedStatement.setString(3, quanLyChatLieu.getNameType());
            preparedStatement.setString(4, quanLyChatLieu.getDescribe());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public QuanLyChatLieu selectUser(String id) {
        QuanLyChatLieu quanLyChatLieu = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idChatLieu = rs.getInt("id");
                String nameId = rs.getString("ma_chat_lieu");
                String nameType = rs.getString("ten");
                String describe = rs.getString("mo_ta");
                quanLyChatLieu = new QuanLyChatLieu(idChatLieu, nameId, nameType, describe);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return quanLyChatLieu;
    }

    @Override
    public boolean update(QuanLyChatLieu quanLyChatLieu) {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);) {
            statement.setInt(1, quanLyChatLieu.getId());
            statement.setString(2, quanLyChatLieu.getNameId());
            statement.setString(3, quanLyChatLieu.getNameType());
            statement.setString(4, quanLyChatLieu.getDescribe());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }


    @Override
    public List<QuanLyChatLieu> displayAll() {
        List<QuanLyChatLieu> quanLyChatLieus = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(DISPLAY_ALL_USERS);) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {

                String nameId = rs.getString("ma_chat_lieu");
                String nameType = rs.getString("ten");
                String describe = rs.getString("mo_ta");
                quanLyChatLieus.add(new QuanLyChatLieu(nameId, nameType, describe));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quanLyChatLieus;
    }

    @Override
    public List<QuanLyChatLieu> search(String word) throws SQLException {
        return null;
    }

    @Override
    public List<QuanLyChatLieu> selectAllByName(String word) {
        List<QuanLyChatLieu> quanLyChatLieuList = new ArrayList<>();
        ResultSet resultSet;
        try {
            Connection connection = getConnection();
            if (word.equals("all")) {
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SIZE_BY_NAME);
                resultSet = preparedStatement.executeQuery();
            } else {
                String sqlQuery = SEARCH_SIZE_BY_NAME + " and ten = '" + word + "'";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();
            }
            while (resultSet.next()) {
                String nameId = resultSet.getString("ma_chat_lieu");
                String nameValue = resultSet.getString("ten");
                String describe = resultSet.getString("mo_ta");
                quanLyChatLieuList.add(new QuanLyChatLieu(nameId, nameValue, describe));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quanLyChatLieuList;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public int getIdByCode(String code) {
        Connection connection = getConnection();
        int id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_BY_CODE);
            preparedStatement.setString(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");

            } else {
                id = -1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public List<String> getAllName() {
        List<String> stringList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            String name;
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("ten");
                stringList.add(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }

    @Override
    public boolean delete(int id) {
        Boolean rowDelete;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }
}
