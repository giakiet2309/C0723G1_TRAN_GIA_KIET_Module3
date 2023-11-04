package service;

import model.QuanLyChatLieu;
import repository.IQuanLyChatLieuRepository;
import repository.QuanLyChatLieuRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class QuanLyChatLieuService implements IQuanLyChatLieuService{
    private static IQuanLyChatLieuRepository quanLyChatLieuRepository =  new QuanLyChatLieuRepository();


    @Override
    public void insert(QuanLyChatLieu quanLyChatLieu) {
        quanLyChatLieuRepository.insert(quanLyChatLieu);
    }

    @Override
    public QuanLyChatLieu select(String id) {
        return quanLyChatLieuRepository.selectUser(id);
    }

    @Override
    public List<QuanLyChatLieu> selectAll() {
        return quanLyChatLieuRepository.displayAll();
    }

    @Override
    public boolean update(QuanLyChatLieu quanLyChatLieu) {
        return quanLyChatLieuRepository.update(quanLyChatLieu);
    }

    @Override
    public List<QuanLyChatLieu> selectAllByName(String name) {
        return quanLyChatLieuRepository.selectAllByName(name);
    }

    @Override
    public int getIdByCode(String code) {
        return quanLyChatLieuRepository.getIdByCode(code);
    }

    @Override
    public List<String> getAllName() {
        return quanLyChatLieuRepository.getAllName();
    }

}
