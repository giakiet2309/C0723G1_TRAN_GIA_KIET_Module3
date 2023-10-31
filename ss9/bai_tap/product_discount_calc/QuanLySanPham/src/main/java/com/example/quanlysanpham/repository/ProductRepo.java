package com.example.quanlysanpham.repository;

import com.example.quanlysanpham.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"G903", 3500000, "Mouse", "Logitech"));
        products.add(new Product(2,"G913", 4500000, "Keyboard", "Logitech"));
        products.add(new Product(3,"G933", 4500000, "Headphone", "Logitech"));
        products.add(new Product(4,"G102", 150000, "Mouse", "Logitech"));
        products.add(new Product(5,"G733", 233333, "Headphone", "Logitech"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void edit(int id, Product product) {
        products.set(id,product);
    }

    @Override
    public Product detail(int index) {
        return products.get(index);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for(Product product: products){
            if(product.getName().contains(name)){
                searchList.add(product);
            }
        }
        return searchList;
    }
}