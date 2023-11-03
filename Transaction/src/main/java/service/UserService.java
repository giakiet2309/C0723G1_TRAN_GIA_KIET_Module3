package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserService implements IUserService{

    IUserRepository userRepository = new UserRepository();
    @Override
    public String displayUser(HttpServletRequest request, HttpServletResponse response){
        List<User> list = userRepository.getUser();
        String data = "<table><tr>" +
                "<th style='width: 100px'>STT</th>" +
                "<th style='width: 400px'>Tên</th>" +
                "<th style='width: 200px'>Tuổi</th>" +
                "<th style='width: 150px'>Quốc Tịch</th>" +
                "<th style='width: 150px'></th></tr>";
        for (int i = 1; i <= list.size(); i++){
            data += "<tr>" +
                    "<td>" + i + "</td>" +
                    "<td>" + list.get(i - 1).getUserName() + "</td>" +
                    "<td>" + list.get(i - 1).getAge() + "</td>" +
                    "<td>" + list.get(i - 1).getNation() + "</td>" +
                    "<td><button onclick='edit(" + list.get(i - 1).getUserId() + ")'>Sửa</button>" +
                    "<button onclick='deleteById(" + list.get(i - 1).getUserId() + ")'>Xóa</button></td>" +
                    "</tr>";
        }
        data += "</table>";
        return data;
    }

    @Override
    public void editUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String newName = request.getParameter("name");
        int newAge = Integer.parseInt(request.getParameter("age"));
        String newNation = request.getParameter("nation");
        userRepository.editUser(id, newName, newAge, newNation);
    }

    @Override
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("vào get user service");
        return userRepository.getUserById(Integer.parseInt(request.getParameter("id")));
    }

    @Override
    public void addUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("add ở service");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String nation = request.getParameter("nation");
        userRepository.addUser(name, age, nation);
    }
}
