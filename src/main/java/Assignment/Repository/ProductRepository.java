package Assignment.Repository;

import Assignment.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(Double minPrice);

    List<Product> findAllByCategoryNameAndPriceLessThan(String category, Double maxPrice);

    List<Product> findAllByNameContains(String keyword);
}