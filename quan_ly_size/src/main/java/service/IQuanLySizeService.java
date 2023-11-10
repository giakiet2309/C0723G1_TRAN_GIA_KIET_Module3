package service;

import model.QuanLySize;

import java.util.List;

public interface IQuanLySizeService {
    void insert(QuanLySize quanLySize);
    QuanLySize select(String id);

    List<QuanLySize> selectAll();

    boolean update(QuanLySize quanLySize);

    List<QuanLySize> selectAllByName(String name);

    int getIdByCode(String code);

    List<String> getAllName();
    boolean delete(int  id);
}
