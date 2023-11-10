package repository;

import model.ThongTinTaiKhoan;

import java.util.List;

public interface IThongTinTaiKhoanRepository {
    List<String> getAllName();

    ThongTinTaiKhoan displayAll(String userName);

    int getIdByCode(String code);


    boolean update(String name, String email, String telephone, String addres, String gender, String userName, int passWord);

    int selectUser(String id);

    String getPassWord(String id);
}
