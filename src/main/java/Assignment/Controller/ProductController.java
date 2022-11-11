package Assignment.Controller;


import Assignment.Dto.RequestProductDTO;
import Assignment.Entity.Product;
import Assignment.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("products")
@RestController
public class ProductController {

    private final ProductService service;

    @PostMapping
    public RequestProductDTO createProduct(@RequestBody RequestProductDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public RequestProductDTO updateProduct(@PathVariable Long id, @RequestBody RequestProductDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/filter")
    public List<Product> getProductByNameContains(@RequestParam String keyword) {
        return service.getAllProductByNameContain(keyword);
    }

    @GetMapping("/min-price/{min}")
    public List<Product> getAllProductPriceGreaterThan(@PathVariable Double min) {
        return service.getAllProductGreaterThanMinPrice(min);
    }

    @GetMapping("/categories/{cat}/max-price/{max}")
    public List<Product> getAllProductByCategoryAndPriceLessThan(@PathVariable String cat,
                                                                 @PathVariable Double max) {
        return service.getAllProductByCategoryAndLessThanMaxPrice(cat, max);
    }
}
