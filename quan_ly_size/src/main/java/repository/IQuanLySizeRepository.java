package repository;

import model.QuanLySize;

import java.sql.SQLException;
import java.util.List;

public interface IQuanLySizeRepository {
    void insert(QuanLySize quanLySize);

    QuanLySize selectUser(String id);

    boolean update(QuanLySize quanLySize);

    List<QuanLySize> displayAll();

    List<QuanLySize> search(String word) throws SQLException;

    List<QuanLySize> selectAllByName(String word);

    int getIdByCode(String code);

    List<String> getAllName();

    boolean delete(int id);
}
