package com.example.quanlysanpham.controller;
import com.example.quanlysanpham.service.IProductService;
import com.example.quanlysanpham.model.Product;
import com.example.quanlysanpham.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsController", value = "/products")
public class ProductsController extends HttpServlet {
    private final IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(request, response);
                break;
            case "searchId":
                searchId(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "searchName":
                searchName(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default: showAll(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int index = getIndex(id);
        productService.remove(index);
        response.sendRedirect("/products");
    }


    private void searchId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("name"));
        int index = getIndex(id);
        if(index != -1){
            Product product = productService.getAll().get(index);
            request.setAttribute("product",product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/search_product_by_id.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/not_found_product.jsp");
            requestDispatcher.forward(request,response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                add(request, response);
                break;
            case "edit":
                edit(request, response);
                break;


            default: showAll(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name  = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");

        Product product = new Product(id,name,price,description,manufacturer);
        int index = getIndex(id);

        productService.edit(index, product);
        response.sendRedirect("/products");
    }

    private int getIndex(int id){
        int index = -1;
        for(int i =0; i<productService.getAll().size(); i++){
            if(productService.getAll().get(i).getId()==id){
                index=i;
                break;
            }
        }
        return index;
    }


    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        productService.addProduct(new Product(id, name, price, description, manufacturer));

        response.sendRedirect("/products");

    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/add.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int index = getIndex(id);
        Product product = productService.getAll().get(index);
        request.setAttribute("product",product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        request.setAttribute("products1", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/list.jsp");
        requestDispatcher.forward(request, response);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }


    }
    private void searchName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> products = productService.findByName(name);
        if(products.size() != 0){
            request.setAttribute("products",products);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/search_product_by_name.jsp");
            requestDispatcher.forward(request, response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/product/not_found_product.jsp");
            requestDispatcher.forward(request, response);
        }


    }


}
