package com.example.quanlysanpham.repository;

import com.example.quanlysanpham.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        PRODUCTS.add(new Product(1,"G903", 3500000, "Mouse", "Logitech"));
        PRODUCTS.add(new Product(2,"G913", 4500000, "Keyboard", "Logitech"));
        PRODUCTS.add(new Product(3,"G933", 4500000, "Headphone", "Logitech"));
        PRODUCTS.add(new Product(4,"G102", 150000, "Mouse", "Logitech"));
        PRODUCTS.add(new Product(5,"G733", 233333, "Headphone", "Logitech"));
    }

    @Override
    public List<Product> getAll() {
        return PRODUCTS;
    }

    @Override
    public void addProduct(Product product) {
        PRODUCTS.add(product);
    }

    @Override
    public void remove(int id) {
        PRODUCTS.remove(id);
    }

    @Override
    public void edit(int id, Product product) {
        PRODUCTS.set(id,product);
    }

    @Override
    public Product detail(int index) {
        return PRODUCTS.get(index);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for(Product product: PRODUCTS){
            if(product.getName().contains(name)){
                searchList.add(product);
            }
        }
        return searchList;
    }
}