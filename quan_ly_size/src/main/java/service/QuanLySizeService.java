package service;

import model.QuanLySize;
import repository.IQuanLySizeRepository;
import repository.QuanLySizeRepository;

import java.util.List;

public class QuanLySizeService implements IQuanLySizeService {
    private static IQuanLySizeRepository quanLySizeRepository = new QuanLySizeRepository();
    @Override
    public void insert(QuanLySize quanLySize) {
        quanLySizeRepository.insert(quanLySize);
    }

    @Override
    public QuanLySize select(String id) {
        return quanLySizeRepository.selectUser(id);
    }

    @Override
    public List<QuanLySize> selectAll() {
        return quanLySizeRepository.displayAll();
    }

    @Override
    public boolean update(QuanLySize quanLySize) {
        return quanLySizeRepository.update(quanLySize);
    }

    @Override
    public List<QuanLySize> selectAllByName(String name) {
        return quanLySizeRepository.selectAllByName(name);
    }

    @Override
    public int getIdByCode(String code) {
        return quanLySizeRepository.getIdByCode(code);
    }

    @Override
    public List<String> getAllName() {
        return quanLySizeRepository.getAllName();
    }

    @Override
    public boolean delete(int id) {
        return quanLySizeRepository.delete(id);
    }

}
