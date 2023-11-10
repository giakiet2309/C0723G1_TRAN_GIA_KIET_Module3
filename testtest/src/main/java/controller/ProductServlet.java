package controller;

import model.ProductDTO;
import service.IProductService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Product", value = "/products")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                insertProduct(request, response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                showFormCreate(request, response);
                break;
            case "delete":
//                deleteProduct(request, response);
                break;
            case "search":
//                searchProduct(request, response);
                break;
            case "search-cu":
//                searchProducTypeByName();
            default:
                listProduct(request, response);
                break;
        }
    }


    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<ProductDTO> productDTOList = productService.displayAllProduct();
        request.setAttribute("ccc", productDTOList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
