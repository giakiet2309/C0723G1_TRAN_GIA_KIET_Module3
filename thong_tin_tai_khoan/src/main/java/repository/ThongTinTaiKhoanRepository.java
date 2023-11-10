package repository;

import model.ThongTinTaiKhoan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongTinTaiKhoanRepository implements IThongTinTaiKhoanRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/quan_ly_ban_hang";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String GET_INFO_BY_USERNAME = "select ho_ten,email,so_dien_thoai,dia_chi,gioi_tinh,user_name,pass_word from khach_hang kh " +
            "join tai_khoan tk on kh.id_tai_khoan = tk.id where user_name = ?";
    private static final String SEARCH_MEMBER_SQL = "select ho_ten from khach_hang ";

    private static final String UPDATE_USERS = "call update_member_all(?,?,?,?,?,?)";

    private static final String SELECT_USER_BY_ID = "select * from khach_hang where ma_khach_hang = ? ";
    private static final String SELECT_ID_BY_CODE = "select kh.id from khach_hang kh\n" +
            "join tai_khoan tk on kh.id_tai_khoan = tk.id where user_name = ?;\n;";

    private static final String GET_ID_BY_USER = "select kh.id from khach_hang kh  " +
            "join tai_khoan tk on kh.id_tai_khoan = tk.id where user_name = ?;";

    private static final String GET_PASS = "select tk.pass_word from khach_hang kh  " +
            "join tai_khoan tk on kh.id_tai_khoan = tk.id where user_name = ?;";


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
    public List<String> getAllName() {
        List<String> stringList = new ArrayList<>();
        Connection connection = getConnection();
        String name;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MEMBER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("ho_ten");
                stringList.add(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stringList;
    }

    @Override
    public ThongTinTaiKhoan displayAll(String taiKhoan) {
        Connection connection = getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(GET_INFO_BY_USERNAME);
            callableStatement.setString(1, taiKhoan);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String nameMember = resultSet.getString("ho_ten");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("so_dien_thoai");
                String address = resultSet.getString("dia_chi");
                String gender = resultSet.getString("gioi_tinh");
                String userName = resultSet.getString("user_name");
                String passWord = resultSet.getString("pass_word");
                ThongTinTaiKhoan thongTinTaiKhoan = new ThongTinTaiKhoan(nameMember, email, phoneNumber, address, gender, userName, passWord);
                return thongTinTaiKhoan;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
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
    public boolean update(String name, String email, String telephone, String address, String gender, String userName, int idAcccount) {

        boolean rowUpdated;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, telephone);
            statement.setString(4, address);
            statement.setString(5, gender);
            statement.setInt(6, idAcccount);
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public int selectUser(String userName) {

        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_BY_USER);
            preparedStatement.setString(1, userName);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public String getPassWord(String id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PASS);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
