package service;

import model.QuanLyChatLieu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IQuanLyChatLieuService {
    void insert(QuanLyChatLieu quanLyChatLieu);
    QuanLyChatLieu select(String id);

    List<QuanLyChatLieu> selectAll();

    boolean update(QuanLyChatLieu quanLyChatLieu);

    List<QuanLyChatLieu> selectAllByName(String name);

    int getIdByCode(String code);

    List<String> getAllName();
    boolean delete(int  id);
}
