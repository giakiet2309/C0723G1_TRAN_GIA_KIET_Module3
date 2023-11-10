package service;

import model.ThongTinTaiKhoan;

import java.util.List;

public interface IThongTinTaiKhoanService {
    ThongTinTaiKhoan selectAll(String userName);

    List<String> getAllName();

    int getIdByCode(String code);

     boolean update(String name, String email, String telephone, String address, String gender, String userName, int idAcccount);

    int selectUser(String id);

    String getPassWord(String id);
}
