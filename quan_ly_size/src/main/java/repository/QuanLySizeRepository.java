package repository;

import jdk.nashorn.internal.codegen.CompilerConstants;
import model.QuanLySize;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLySizeRepository implements IQuanLySizeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/quan_ly_ban_hang";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_USERS_SQL = "insert into size (id,ma_size,ten_size,mo_ta) values (?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "select * from size where ma_size=? ";

    private static final String SEARCH_USERS_SQL = "select ten_size from size where ten_size != 'not found';";

    private static final String DISPLAY_ALL_USERS = "call display_size_all()";

    private static final String UPDATE_USERS = "call update_size_all(?,?,?,?)";

    private static final String SEARCH_SIZE_BY_NAME = " select ma_size,ten_size,mo_ta from size where 1 = 1 and ten_size != 'not found'";

//    private static final String SELECT_ALL_BY_NAME = "select * from users where ten like ?";

    private static final String SELECT_ID_BY_CODE = "select id from size where ma_size =  ?;";

    private static final String UPDATE_CUSTOMER_TYPE_BY_ID = "update size set ten_size = 'not found',mo_ta = 'not found' where id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(QuanLySize quanLySize) {
        System.out.println(INSERT_USERS_SQL);
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1, quanLySize.getId());
            preparedStatement.setString(2, quanLySize.getSizeId());
            preparedStatement.setString(3, quanLySize.getNameSize());
            preparedStatement.setString(4, quanLySize.getDescribe());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public QuanLySize selectUser(String id) {
        QuanLySize quanLySize = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idSize = resultSet.getInt("id");
                String nameId = resultSet.getString("ma_size");
                String nameSize = resultSet.getString("ten_size");
                String describe = resultSet.getString("mo_ta");
                quanLySize = new QuanLySize(idSize, nameId, nameSize, describe);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return quanLySize;
    }

    @Override
    public boolean update(QuanLySize quanLySize) {
        boolean rowUpdated;

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);
            statement.setInt(1, quanLySize.getId());
            statement.setString(2, quanLySize.getSizeId());
            statement.setString(3, quanLySize.getNameSize());
            statement.setString(4, quanLySize.getDescribe());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public List<QuanLySize> displayAll() {
        List<QuanLySize> quanLySizes = new ArrayList<>();
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(DISPLAY_ALL_USERS);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String nameId = resultSet.getString("ma_size");
                String nameSize = resultSet.getString("ten_size");
                String describe = resultSet.getString("mo_ta");
                quanLySizes.add(new QuanLySize(nameId, nameSize, describe));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quanLySizes;
    }

    @Override
    public List<QuanLySize> search(String word) throws SQLException {
        return null;
    }

    @Override
    public List<QuanLySize> selectAllByName(String word) {
        List<QuanLySize> quanLySizeList = new ArrayList<>();
        ResultSet resultSet;
        try {
            Connection connection = getConnection();
            if (word.equals("all")) {
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SIZE_BY_NAME);
                resultSet = preparedStatement.executeQuery();
            } else {
                String sqlQuery = SEARCH_SIZE_BY_NAME + " and ten_size = '" + word + "'";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();
            }
            while (resultSet.next()) {
                String nameId = resultSet.getString("ma_size");
                String nameSize = resultSet.getString("ten_size");
                String describe = resultSet.getString("mo_ta");
                quanLySizeList.add(new QuanLySize(nameId, nameSize, describe));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quanLySizeList;
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

        try {
            Connection connection = getConnection();
            String name;
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("ten_size");
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
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_TYPE_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
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
}
