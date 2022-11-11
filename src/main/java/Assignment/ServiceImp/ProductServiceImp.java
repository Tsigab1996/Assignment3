package Assignment.ServiceImp;

import Assignment.Dto.RequestProductDTO;
import Assignment.Entity.Product;
import Assignment.Repository.CategoryRepository;
import Assignment.Repository.ProductRepository;
import Assignment.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public RequestProductDTO save(RequestProductDTO product) {
        // assume client provide valid category
        Product p = new Product();
        BeanUtils.copyProperties(product, p, "id");
        p.setCategory(categoryRepository.findById(product.getCategoryId()).get());
        repository.save(p);
        return product;
    }

    @Override
    public RequestProductDTO update(Long id, RequestProductDTO product) {
        Optional<Product> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new RuntimeException("Product not found!");
        }
        Product p = optional.get();
        BeanUtils.copyProperties(product, p, "id");
        // assume client provide valid category
        p.setCategory(categoryRepository.findById(product.getCategoryId()).get());
        repository.save(p);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public List<Product> getAllProductGreaterThanMinPrice(Double minPrice) {
        return repository.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getAllProductByCategoryAndLessThanMaxPrice(String catName, Double maxPrice) {
        return repository.findAllByCategoryNameAndPriceLessThan(catName, maxPrice);
    }

    @Override
    public List<Product> getAllProductByNameContain(String keyword) {
        return repository.findAllByNameContains(keyword);
    }
}
