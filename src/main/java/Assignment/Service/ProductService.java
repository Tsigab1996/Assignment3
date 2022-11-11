package Assignment.Service;

import Assignment.Dto.RequestProductDTO;
import Assignment.Entity.Product;

import java.util.List;

public interface ProductService {

    RequestProductDTO save(RequestProductDTO product);

    RequestProductDTO update(Long id, RequestProductDTO product);

    List<Product> getAllProduct();

    List<Product> getAllProductGreaterThanMinPrice(Double minPrice);

    List<Product> getAllProductByCategoryAndLessThanMaxPrice(String catName, Double maxPrice);

    List<Product> getAllProductByNameContain(String keyword);
}