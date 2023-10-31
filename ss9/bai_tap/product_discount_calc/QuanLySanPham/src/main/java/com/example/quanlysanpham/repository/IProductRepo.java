package com.example.quanlysanpham.repository;

import com.example.quanlysanpham.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAll();

    void addProduct(Product product);

    void remove(int id);

    void edit(int id, Product product);
    List<Product> findByName(String name);

    Product detail(int id);


}
