package controller;

import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Users", value = "/users")
public class UserController extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("vào doget controller");

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "displayAll":
                System.out.println("displayAll");
                String data = userService.displayUser(request, response);
                request.setAttribute("data", data);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;

            case "edit":
                System.out.println("edit");
                User user = userService.getUserById(request, response);
                System.out.println(user);
                request.setAttribute("id", user.getUserId());
                request.setAttribute("name", user.getUserName());
                request.setAttribute("age", user.getAge());
                request.setAttribute("nation", user.getNation());
                request.getRequestDispatcher("/edit.jsp").forward(request,response);
                break;
            case "delete":
                System.out.println("delete");
                userService.deleteUser(request, response);
                response.sendRedirect("/index.jsp");
                break;
            case "add":
                System.out.println("add");
                response.sendRedirect("/add.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "edit":
                System.out.println("edit do post");
                userService.editUser(request,response);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            case "add":
                System.out.println("add do post");
                userService.addUser(request,response);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
        }
    }
}
