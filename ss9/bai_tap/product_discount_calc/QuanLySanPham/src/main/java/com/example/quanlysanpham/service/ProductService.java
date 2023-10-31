package com.example.quanlysanpham.service;

import com.example.quanlysanpham.model.Product;
import com.example.quanlysanpham.repository.IProductRepo;
import com.example.quanlysanpham.repository.ProductRepo;

import java.util.List;

public class ProductService implements IProductService {

    private final IProductRepo productRepo = new ProductRepo();
    @Override
    public List<Product> getAll() {
        return productRepo.getAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public void remove(int id) {
        productRepo.remove(id);
    }

    @Override
    public void edit(int id, Product product) {
        productRepo.edit(id, product);
    }

    @Override
    public Product detail(int id) {

        return productRepo.detail(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }
}
