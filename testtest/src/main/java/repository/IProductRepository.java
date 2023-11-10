package repository;

import model.ProductDTO;

import java.util.List;

public interface IProductRepository {
    List<ProductDTO> displayAllProduct();
}
