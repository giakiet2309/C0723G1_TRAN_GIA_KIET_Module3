package service;


import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface IUserService {
    String displayUser(HttpServletRequest request, HttpServletResponse response);
    void editUser(HttpServletRequest request, HttpServletResponse response);
    void deleteUser(HttpServletRequest request, HttpServletResponse response);
    User getUserById(HttpServletRequest request, HttpServletResponse response);
    void addUser(HttpServletRequest request, HttpServletResponse response);
}