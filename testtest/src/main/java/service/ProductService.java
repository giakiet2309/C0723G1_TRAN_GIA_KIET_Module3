package service;

import model.ProductDTO;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private final IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductDTO> displayAllProduct() {
        return productRepository.displayAllProduct();
    }
}
