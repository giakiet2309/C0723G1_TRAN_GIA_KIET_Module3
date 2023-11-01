package com.example.quanlysanpham.service;

import com.example.quanlysanpham.model.Product;
import com.example.quanlysanpham.repository.IProductRepo;
import com.example.quanlysanpham.repository.ProductRepo;

import java.util.List;

public class ProductService implements IProductService {

    private final IProductRepo PRODUCTREPO = new ProductRepo();
    @Override
    public List<Product> getAll() {
        return PRODUCTREPO.getAll();
    }

    @Override
    public void addProduct(Product product) {
        PRODUCTREPO.addProduct(product);
    }

    @Override
    public void remove(int id) {
        PRODUCTREPO.remove(id);
    }

    @Override
    public void edit(int id, Product product) {
        PRODUCTREPO.edit(id, product);
    }

    @Override
    public Product detail(int id) {

        return PRODUCTREPO.detail(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return PRODUCTREPO.findByName(name);
    }
}
