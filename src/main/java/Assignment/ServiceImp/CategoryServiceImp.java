package Assignment.ServiceImp;

import Assignment.Dto.RequestCategoryDTO;
import Assignment.Entity.Category;
import Assignment.Repository.CategoryRepository;
import Assignment.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public RequestCategoryDTO save(RequestCategoryDTO category) {
        Category cat = new Category();
        BeanUtils.copyProperties(category, cat, "id");
        repository.save(cat);
        return category;
    }

    @Override
    public RequestCategoryDTO update(Long id, RequestCategoryDTO category) {
        Optional<Category> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Category not found!");
        }
        Category cat = optional.get();
        BeanUtils.copyProperties(category, cat, "id");
        repository.save(cat);
        return category;
    }

    @Override
    public List<Category> getAllCategory() {
        return repository.findAll();
    }

    @Override
    public Boolean deleteCategory(Long id) {
        repository.deleteById(id);
        return true;
    }
}
