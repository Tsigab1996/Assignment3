package Assignment.Controller;


import Assignment.Dto.RequestCategoryDTO;
import Assignment.Entity.Category;
import Assignment.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("categories")
@RestController
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public RequestCategoryDTO createCategory(@RequestBody RequestCategoryDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public RequestCategoryDTO updateCategory(@PathVariable Long id, @RequestBody RequestCategoryDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAllCategory();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCategory(@PathVariable Long id) {
        return service.deleteCategory(id);
    }
}
