package service;

import model.ThongTinTaiKhoan;
import repository.IThongTinTaiKhoanRepository;
import repository.ThongTinTaiKhoanRepository;

import java.util.List;

public class ThongTinTaiKhoanService implements IThongTinTaiKhoanService {
    private static IThongTinTaiKhoanRepository thongTinTaiKhoanRepository = new ThongTinTaiKhoanRepository();

    @Override
    public ThongTinTaiKhoan selectAll(String userName) {
        return thongTinTaiKhoanRepository.displayAll(userName);
    }

    @Override
    public List<String> getAllName() {
        return thongTinTaiKhoanRepository.getAllName();
    }

    @Override
    public int getIdByCode(String code) {
        return thongTinTaiKhoanRepository.getIdByCode(code);
    }

    @Override
    public boolean update(String name, String email, String telephone, String address, String gender, String userName, int idAcccount) {
        return thongTinTaiKhoanRepository.update( name,  email,  telephone,  address,  gender,  userName,idAcccount);
    }

    @Override
    public int selectUser(String id) {
        return thongTinTaiKhoanRepository.selectUser(id);
    }

    @Override
    public String getPassWord(String id) {
        return thongTinTaiKhoanRepository.getPassWord(id);
    }
}
