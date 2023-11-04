package repository;

import model.QuanLyChatLieu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface IQuanLyChatLieuRepository {
    void insert(QuanLyChatLieu quanLyChatLieu);
    QuanLyChatLieu selectUser(String id);

    boolean update(QuanLyChatLieu quanLyChatLieu);

    List<QuanLyChatLieu> displayAll();

    List<QuanLyChatLieu> search(String word) throws SQLException;

    List<QuanLyChatLieu> selectAllByName(String word);

    int getIdByCode(String code);

    List<String> getAllName();


}
