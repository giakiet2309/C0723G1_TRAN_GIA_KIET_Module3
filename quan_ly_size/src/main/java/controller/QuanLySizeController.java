package controller;

import model.QuanLySize;
import service.QuanLySizeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuanLySizeController", urlPatterns = "/quan_ly_size")
public class QuanLySizeController extends HttpServlet {
    private final QuanLySizeService quanLySizeService = new QuanLySizeService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                insert(req, resp);
                break;
            case "edit":
                update(req, resp);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "delete":
                delete(request, response);
            default:
                displayAll(request, response);
                break;
        }
    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        String nameId = request.getParameter("nameId");
        String nameType = request.getParameter("nameType");
        String describe = request.getParameter("describe");
        QuanLySize quanLySize = new QuanLySize(nameId, nameType, describe);
        quanLySizeService.insert(quanLySize);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("sizeId");
        String nameType = request.getParameter("nameSize");
        String describe = request.getParameter("describe");
        int id = quanLySizeService.getIdByCode(code);
        QuanLySize quanLySize = new QuanLySize(id, code, nameType, describe);
        quanLySizeService.update(quanLySize);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws SecurityException, ServletException, IOException {
        String code = request.getParameter("id");
        int id = quanLySizeService.getIdByCode(code);
        quanLySizeService.delete(id);
        displayAll(request, response);
    }

    public void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<QuanLySize> quanLySizes = quanLySizeService.selectAll();
        List<String> listName = quanLySizeService.getAllName();
        request.setAttribute("listName", listName);
        request.setAttribute("list", quanLySizes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word = request.getParameter("nameSize");
        List<QuanLySize> quanLyChatLieuList = quanLySizeService.selectAllByName(word);
        List<String> listName = quanLySizeService.getAllName();
        request.setAttribute("listName", listName);
        request.setAttribute("list", quanLyChatLieuList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        QuanLySize quanLySize = quanLySizeService.select(id);
        request.setAttribute("quanLySize", quanLySize);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
